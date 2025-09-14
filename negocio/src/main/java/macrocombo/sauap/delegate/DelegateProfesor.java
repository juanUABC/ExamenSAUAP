package macrocombo.sauap.delegate;

import macrocombo.sauap.entity.Administrador;
import macrocombo.sauap.entity.Profesor;
import macrocombo.sauap.integration.ServiceLocator;

import java.util.List;

public class DelegateProfesor {
    public void saveProfesor(Profesor profesor){
        ServiceLocator.getInstanceProfesorDAO().save(profesor);
    }

    public List<Profesor> getProfesores(){
        return ServiceLocator.getInstanceProfesorDAO().findAll();
    }
}