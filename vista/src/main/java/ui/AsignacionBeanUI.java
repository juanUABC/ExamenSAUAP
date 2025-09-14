package ui;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import macrocombo.sauap.entity.Asigna;
import macrocombo.sauap.integration.ServiceFacadeLocator;
import macrocombo.sauap.entity.Profesor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("asignacionUI")
@ViewScoped
public class AsignacionBeanUI implements Serializable {
    private Asigna asigna;

    private List<Profesor> profesores;


    @PostConstruct
    public void init() {
        asigna = new Asigna();
        profesores = ServiceFacadeLocator.getInstanceFacadeProfesor().obtenerProfesores();
    }

    public void guardar() {
        try {
            ServiceFacadeLocator.getInstanceFacadeAsigna().guardarAsigna(asigna);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Éxito",
                            "Unidad de aprendizaje asignada correctamente"));

            this.asigna = new Asigna();
        } catch (IllegalArgumentException ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error",
                            ex.getMessage()));
        }
    }

    public Asigna getAsigna() {
        return asigna;
    }

    public void setAsigna(Asigna asigna) {
        this.asigna = asigna;
    }

    public List<Profesor> getProfesores() {
        return this.profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores= profesores;
    }
}

