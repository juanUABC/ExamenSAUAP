package macrocombo.sauap.facade;

import macrocombo.sauap.delegate.DelegateUnidadAprendizaje;
import macrocombo.sauap.entity.UnidadAprendizaje;

public class FacadeUnidadAprendizaje {

    private final DelegateUnidadAprendizaje delegateUnidadAprendizaje;

    public FacadeUnidadAprendizaje() {
        this.delegateUnidadAprendizaje = new DelegateUnidadAprendizaje();
    }

    public void guardarUnidadAprendizaje(UnidadAprendizaje up){
        delegateUnidadAprendizaje.saveUnidadAprendizaje(up);
    }

}