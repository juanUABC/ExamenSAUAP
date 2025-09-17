package ui;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import macrocombo.sauap.entity.Asigna;
import macrocombo.sauap.entity.UnidadAprendizaje;
import macrocombo.sauap.entity.enums.DiaSemana;
import macrocombo.sauap.integration.ServiceFacadeLocator;
import macrocombo.sauap.entity.Profesor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("asignacionUI")
@ViewScoped
public class AsignacionBeanUI implements Serializable {
    private Asigna asigna;
    private Integer idProfesor;
    private Integer idUnidad;
    private List<Profesor> profesores;
    private List<UnidadAprendizaje> unidades;


    @PostConstruct
    public void init() {
        asigna = new Asigna();
        profesores = ServiceFacadeLocator.getInstanceFacadeProfesor().obtenerProfesores();
        unidades = ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().obtenerUnidades();
    }

    public void guardar() {
        try {
            ServiceFacadeLocator.getInstanceFacadeAsigna(). guardarAsigna(asigna, idProfesor, idUnidad);

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

    public void cargarAsigna() {
        this.asigna = ServiceFacadeLocator.getInstanceFacadeAsigna().obtenerPorID(asigna.getId());
    }

    public void eliminar() {
        //Mucho copy (-_-
        try {
            cargarAsigna();
        } catch (IllegalArgumentException ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error",
                            ex.getMessage()));
            return;
        }

        try {
            ServiceFacadeLocator.getInstanceFacadeAsigna().eliminar(asigna);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Éxito",
                            "Asignacion eliminada correctamente"));

            this.asigna = new Asigna();
        } catch (IllegalArgumentException ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error",
                            ex.getMessage()));
        }
    }

    public void modificar() {
        try {
            cargarAsigna();
        } catch (IllegalArgumentException ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error",
                            ex.getMessage()));
            return; //No se si este realmente sea necesario, pero no me complicare la existencia!!!
        }

        try {
            ServiceFacadeLocator.getInstanceFacadeAsigna().modificarAsigna(asigna, idProfesor, idUnidad);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Éxito",
                            "Asignacion modificada correctamente"));

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

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer unidad) {
        this.idUnidad = unidad;
    }

    public List<Profesor> getProfesores() {
        return this.profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores= profesores;
    }

    public List<UnidadAprendizaje> getUnidades() {
        return this.unidades;
    }

    public void setUnidades(List<UnidadAprendizaje> unidades) {
        this.unidades= unidades;
    }

    public DiaSemana[] getDiasSemana() {
        return DiaSemana.values();
    }

}

