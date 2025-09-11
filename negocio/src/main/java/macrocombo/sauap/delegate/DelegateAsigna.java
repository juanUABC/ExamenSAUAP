package macrocombo.sauap.delegate;

import macrocombo.sauap.entity.Asigna;
import macrocombo.sauap.integration.ServiceLocator;

public class DelegateAsigna {
    public void saveAsigna(Asigna asigna){
        ServiceLocator.getInstanceAsignaDAO().save(asigna);
    }
}