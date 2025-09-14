package ui;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
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
        try {
            ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje()
                    .guardarUnidadAprendizaje(unidadAprendizaje);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Éxito",
                            "Unidad de aprendizaje registrada correctamente"));

            this.unidadAprendizaje = new UnidadAprendizaje();
        } catch (IllegalArgumentException ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error",
                            ex.getMessage()));
        }
    }

    public UnidadAprendizaje getUnidadAprendizaje() {
        return unidadAprendizaje;
    }

    public void setUnidadAprendizaje(UnidadAprendizaje unidadAprendizaje) {
        this.unidadAprendizaje = unidadAprendizaje;
    }
}

