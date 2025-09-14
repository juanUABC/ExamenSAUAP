package ui;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import macrocombo.sauap.entity.UnidadAprendizaje;
import macrocombo.sauap.integration.ServiceFacadeLocator;

import java.io.Serializable;

@Named("unidadAprendizajeUI")
@ViewScoped
public class UnidadAprendizajeBeanUI implements Serializable {
    private UnidadAprendizaje unidadAprendizaje;
    @PostConstruct
    public void init() {
        unidadAprendizaje = new UnidadAprendizaje();
    }

    public void guardar() {
        ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().guardarUnidadAprendizaje(unidadAprendizaje);
        this.unidadAprendizaje = new UnidadAprendizaje();
    }

    public UnidadAprendizaje getUnidadAprendizaje() {
        return unidadAprendizaje;
    }

    public void setUnidadAprendizaje(UnidadAprendizaje unidadAprendizaje) {
        this.unidadAprendizaje = unidadAprendizaje;
    }
}

