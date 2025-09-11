package macrocombo.sauap.delegate;

import macrocombo.sauap.entity.Profesor;
import macrocombo.sauap.integration.ServiceLocator;

public class DelegateProfesor {
    public void saveProfesor(Profesor profesor){
        ServiceLocator.getInstanceProfesorDAO().save(profesor);
    }
}