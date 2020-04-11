package br.com.speedup.dbengine.documentmanager;



import br.com.speedup.dbengine.documentmanager.interfaces.ManagerDocument;
import br.com.speedup.dbengine.model.DocumentModel;
import br.com.speedup.dbengine.model.KeyModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DocumentManagerImp implements ManagerDocument {

    private Set<DocumentModel> documentModels;

    private DocumentManagerImp() {
        documentModels = new HashSet<>();
    }

    @Override
    public DocumentModel getDocumentModel(KeyModel key) {

        final List<DocumentModel> documents = documentModels.stream().parallel()
                .filter((value -> value.getKey().equals(key)))
                .collect(Collectors.toList());

        if (documents == null || documents.size() == 0) {
            return null;
        }

        return documents.get(0);
    }

    public static ManagerDocument createManagerDocument() {
        return new DocumentManagerImp();
    }

    @Override
    public void addDocument(KeyModel key, KeyModel value) {

        DocumentModel documentModel = getDocumentModel(key);

        if (documentModel == null) {
            documentModel = new DocumentModel(key);
            documentModels.add(documentModel);
        }

        documentModel.getKeyModels().add(value);

    }

    @Override
    public void addDocument(DocumentModel documentModel) {

        documentModels.add(documentModel);
    }

    @Override
    public void removeDocument(DocumentModel key) {
        documentModels.remove(key);
    }
}
