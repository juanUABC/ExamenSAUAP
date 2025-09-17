// java
package ui;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import macrocombo.sauap.entity.UnidadAprendizaje;
import macrocombo.sauap.integration.ServiceFacadeLocator;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.Optional;

@Named("eliminarUnidadBeanUI")
@ViewScoped
public class eliminarUnidadBeanUI implements Serializable {
    private String idBuscar;
    private boolean unidadEncontrada = false;
    private UnidadAprendizaje unidad;
    private String errorMessage;
    private String successMessage;

    @PostConstruct
    public void init() {
        unidad = new UnidadAprendizaje();
    }

    public void buscarUnidadPorId() {
        try {
            Integer id = Integer.parseInt(idBuscar);
            Optional<UnidadAprendizaje> opt = ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().obtenerUnidadPorID(id);
            unidad = opt.orElse(null);

            if (unidad != null) {
                unidadEncontrada = true;
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Unidad encontrada", ""));
            } else {
                unidadEncontrada = false;
                unidad = new UnidadAprendizaje();
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unidad no encontrada", ""));
            }
            PrimeFaces.current().ajax().update("formEliminar");
        } catch (NumberFormatException e) {
            unidad = new UnidadAprendizaje();
            unidadEncontrada = false;
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "ID inválido", "El ID debe ser un número entero."));
            PrimeFaces.current().ajax().update("formEliminar mensaje");
        } catch (Exception e) {
            unidad = new UnidadAprendizaje();
            unidadEncontrada = false;
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al buscar", e.getMessage()));
            PrimeFaces.current().ajax().update("formEliminar mensaje");
        }
    }

    public void eliminarUnidad() {
        if (unidadEncontrada && unidad != null && unidad.getId() != null) {
            try {
                ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().eliminarUnidadAprendizaje(unidad.getId());

                FacesContext fc = FacesContext.getCurrentInstance();
                fc.getMessageList().clear();
                fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Unidad eliminada correctamente", ""));

                // Reset al estado inicial
                unidad = new UnidadAprendizaje();
                unidadEncontrada = false;
                idBuscar = null;
                errorMessage = null;

                // Mensaje para el diálogo de éxito
                successMessage = "Unidad eliminada correctamente";

                // Actualizar formulario y mostrar diálogo de éxito
                PrimeFaces.current().ajax().update("formEliminar");
                PrimeFaces.current().executeScript("PF('dlgSuccess').show();");
            } catch (Exception ex) {
                // Mostrar diálogo con el error y reiniciar estado
                errorMessage = ex.getMessage() != null ? ex.getMessage() : "Error inesperado al eliminar";
                unidad = new UnidadAprendizaje();
                unidadEncontrada = false;
                idBuscar = null;
                FacesContext.getCurrentInstance().getMessageList().clear();
                PrimeFaces.current().ajax().update("formEliminar");
                PrimeFaces.current().executeScript("PF('dlgErrorElim').show();");
            }
        }
    }

    // Getters y Setters
    public String getIdBuscar() { return idBuscar; }
    public void setIdBuscar(String idBuscar) { this.idBuscar = idBuscar; }
    public boolean isUnidadEncontrada() { return unidadEncontrada; }
    public void setUnidadEncontrada(boolean unidadEncontrada) { this.unidadEncontrada = unidadEncontrada; }
    public UnidadAprendizaje getUnidad() { return unidad; }
    public void setUnidad(UnidadAprendizaje unidad) { this.unidad = unidad; }
    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }
    public String getSuccessMessage() { return successMessage; }
    public void setSuccessMessage(String successMessage) { this.successMessage = successMessage; }
}
