package br.com.speedup.dbengine.keymanager;

import br.com.speedup.dbengine.keymanager.interfaces.ManagerData;
import br.com.speedup.dbengine.model.KeyModel;

import java.util.HashSet;
import java.util.Set;

public abstract class ValueMap implements ManagerData {

    private Set<KeyModel> keyModels;

    public ValueMap() {
        keyModels = new HashSet<>();
    }

    @Override
    public KeyModel addKeyValue(String value) {
        KeyModel keyModel = new KeyModel(value);
        keyModels.add(keyModel);
        return keyModel;
    }

    @Override
    public void addKeyValue(KeyModel value) { keyModels.add(value); }

    @Override
    public void removeKeyValue(String value) {
        keyModels.remove(new KeyModel(value));
    }

    @Override
    public void removeKeyValue(KeyModel value) {
        keyModels.remove(value);
    }

    @Override
    public long length() {
        return keyModels.size();
    }

    @Override
    public Set<KeyModel> getAllKeys() {
        return keyModels;
    }
}
