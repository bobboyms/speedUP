package br.com.speedup.dbengine.keymanager.interfaces;


import br.com.speedup.dbengine.model.KeyModel;

import java.util.Set;

public interface ManagerData {

    long length();
    void removeKeyValue(String value);
    void addKeyValue(KeyModel value);
    void removeKeyValue(KeyModel value);
    KeyModel addKeyValue(String value);
    Set<KeyModel> getAllKeys();

}
