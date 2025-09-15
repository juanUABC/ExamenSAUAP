package macrocombo.sauap.delegate;

import macrocombo.sauap.entity.Profesor;
import macrocombo.sauap.entity.UnidadAprendizaje;
import macrocombo.sauap.integration.ServiceLocator;

import java.util.List;
import java.util.Optional;

public class DelegateUnidadAprendizaje {
    //Que weba escribir UnidadAprendizaje todo el rato wey.
    //                                    Porque esta verde?! xdddd
    // Lo hace intelliJ cuando poner todo, por que todo es literal "Para hacer", es para que veas tus pendientes rapido
    public void saveUnidadAprendizaje(UnidadAprendizaje up){
        ServiceLocator.getInstanceUnidadAprendizajeDAO().save(up);
    }

    public List<UnidadAprendizaje> getUnidades(){
        return ServiceLocator.getInstanceUnidadAprendizajeDAO().findAll();
    }

    public Optional<UnidadAprendizaje> getUnidad(int id){
        return ServiceLocator.getInstanceUnidadAprendizajeDAO().find(id);
    }
}