package br.com.speedup.dbengine.documentmanager.interfaces;


import br.com.speedup.dbengine.model.DocumentModel;
import br.com.speedup.dbengine.model.KeyModel;

public interface ManagerDocument {
    DocumentModel getDocumentModel(KeyModel key);
    void addDocument(KeyModel key, KeyModel value);
    void removeDocument(DocumentModel key);
    void addDocument(DocumentModel documentModel);

}
