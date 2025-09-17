// java
// Archivo: vista/src/main/java/ui/modUnidadBeanUI.java
package ui;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import macrocombo.sauap.entity.UnidadAprendizaje;
import macrocombo.sauap.integration.ServiceFacadeLocator;

import java.io.Serializable;
import java.util.Optional;

@Named("modUnidadBeanUI")
@ViewScoped
public class modUnidadBeanUI implements Serializable {
    private String idBuscar;
    private boolean unidadEncontrada = false;
    private UnidadAprendizaje unidad;

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
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unidad no encontrada", ""));
            }
        } catch (NumberFormatException e) {
            unidad = null;
            unidadEncontrada = false;
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "ID inválido", "El ID debe ser un número entero."));
        } catch (Exception e) {
            unidad = null;
            unidadEncontrada = false;
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al buscar", e.getMessage()));
        }
    }

    public void modificarUnidad() {
        if (unidadEncontrada && unidad != null) {
            try {
                ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().actualizarUnidad(unidad);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Unidad modificada correctamente", ""));

                // --- Reset al estado inicial: limpiar campos y bloquear edición ---
                unidad = new UnidadAprendizaje(); // limpia los campos ligados
                unidadEncontrada = false;         // deshabilita los controles de modificación
                idBuscar = null;                  // limpia el campo de búsqueda de ID
                // --------------------------------------------------------------
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al modificar la unidad", ex.getMessage()));
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
}
