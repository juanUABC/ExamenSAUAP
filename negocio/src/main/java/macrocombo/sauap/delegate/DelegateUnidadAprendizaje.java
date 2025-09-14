package macrocombo.sauap.delegate;

import macrocombo.sauap.entity.UnidadAprendizaje;
import macrocombo.sauap.integration.ServiceLocator;

public class DelegateUnidadAprendizaje {
    //Que weba escribir UnidadAprendizaje todo el rato wey.
    //                                    Porque esta verde?! xdddd
    // Lo hace intelliJ cuando poner todo, por que todo es literal "Para hacer", es para que veas tus pendientes rapido
    public void saveUnidadAprendizaje(UnidadAprendizaje up){
        ServiceLocator.getInstanceUnidadAprendizajeDAO().save(up);
    }
}