package macrocombo.sauap.delegate;

import macrocombo.sauap.entity.UnidadAprendizaje;
import macrocombo.sauap.integration.ServiceLocator;

public class DelegateUnidadAprendizaje {
    //Que weba escribir UnidadAprendizaje todo el rato wey.
    //                                    Porque esta verde?! xdddd
    public void saveUnidadAprendizaje(UnidadAprendizaje up){
        ServiceLocator.getInstanceUnidadAprendizajeDAO().save(up);
    }
}