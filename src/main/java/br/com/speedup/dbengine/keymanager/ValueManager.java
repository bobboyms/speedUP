package br.com.speedup.dbengine.keymanager;


import br.com.speedup.dbengine.keymanager.interfaces.ManagerData;

public class ValueManager extends ValueMap {

    private ValueManager() {
        super();
    }

    public static ManagerData CreateKeyManager() {
        return new ValueManager();
    }

}
