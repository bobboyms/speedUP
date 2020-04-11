package br.com.speedup.dbengine.dbconnection;


import br.com.speedup.dbengine.documentmanager.DocumentManagerImp;
import br.com.speedup.dbengine.documentmanager.interfaces.ManagerDocument;
import br.com.speedup.dbengine.keymanager.ValueManager;
import br.com.speedup.dbengine.keymanager.interfaces.ManagerData;
import br.com.speedup.dbengine.model.DocumentModel;
import br.com.speedup.dbengine.model.KeyModel;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConnectionDB implements Connection {

    private ManagerData managerData;
    private ManagerDocument managerDocument;
    private static ConnectionDB connectionDB;

    private String key;
    private String[] parts;
    private String command;

    private ConnectionDB() {
        managerData = ValueManager.CreateKeyManager();
        managerDocument = DocumentManagerImp.createManagerDocument();
    }

    public static Connection getInstance() {

        if (connectionDB == null) {
            connectionDB = new ConnectionDB();
        }

        return connectionDB;
    }

    public Connection createCommand(String commandLine) {

        parts = commandLine.split(" ");
        command = parts[0].trim().toUpperCase();
        key = parts[1].trim();

        return this;
    }

    @Override
    public void setDocument() {

        final KeyModel keyModel = managerData.addKeyValue(key);

        List<KeyModel> keyModels = IntStream.range(2, parts.length)
                .mapToObj(i -> new KeyModel(parts[i].trim()))
                .collect(Collectors.toList());

        DocumentModel documentModel = managerDocument.getDocumentModel(keyModel);

        if (documentModel != null) {
            documentModel.setKeyModels(keyModels);
        }

        documentModel = new DocumentModel(keyModel, keyModels);
        managerDocument.addDocument(documentModel);
        cleanValues();

    }

    @Override
    public String getDocument() {

        final KeyModel keyModel = managerData.addKeyValue(key);

        StringBuilder stringBuilder = new StringBuilder();
        DocumentModel documentModel = managerDocument.getDocumentModel(keyModel);

        if (documentModel == null) {
            return null;
        }

        documentModel.getKeyModels().stream().forEach(value ->stringBuilder.append(value.getValue() + " "));
        cleanValues();
        return stringBuilder.toString().trim();
    }

    @Override
    public void deleteDocument() {
        final KeyModel keyModel = managerData.addKeyValue(key);
        managerDocument.removeDocument(new DocumentModel(keyModel));
        cleanValues();
    }

    private void cleanValues() {
        parts = null;
        command = null;
        key = null;
    }
}
