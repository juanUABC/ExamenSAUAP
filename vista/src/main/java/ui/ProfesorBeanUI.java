package ui;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import macrocombo.sauap.entity.Profesor;
import macrocombo.sauap.integration.ServiceFacadeLocator;

import java.io.Serializable;
import java.util.List;

@Named("ProfesorUI")
@ViewScoped
public class ProfesorBeanUI implements Serializable {
    private Profesor profesor;
    @PostConstruct
    public void init() {
        profesor = new Profesor();
    }

    public void guardar() {
        try {
            ServiceFacadeLocator.getInstanceFacadeProfesor().guardarProfesor(profesor);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Éxito",
                            "Profesor registrado correctamente"));

            this.profesor = new Profesor();
        } catch (IllegalArgumentException ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error",
                            ex.getMessage()));
        }
    }

    public List<Profesor> getProfesores() {
        return ServiceFacadeLocator.getInstanceFacadeProfesor().obtenerProfesores();
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}

