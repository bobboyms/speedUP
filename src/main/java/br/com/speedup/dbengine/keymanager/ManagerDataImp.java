package br.com.speedup.dbengine.keymanager;


import br.com.speedup.dbengine.keymanager.interfaces.ManagerData;

public class ManagerDataImp extends ValueMap{

    private ManagerDataImp() {
        super();
    }

    public static ManagerData CreateKeyManager() {
        return new ManagerDataImp();
    }

}
