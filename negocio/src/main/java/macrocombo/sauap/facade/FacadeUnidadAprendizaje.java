package macrocombo.sauap.facade;

import macrocombo.sauap.delegate.DelegateUnidadAprendizaje;
import macrocombo.sauap.entity.Profesor;
import macrocombo.sauap.entity.UnidadAprendizaje;

import java.util.List;
import java.util.Optional;

public class FacadeUnidadAprendizaje {

    private final DelegateUnidadAprendizaje delegateUnidadAprendizaje;

    public FacadeUnidadAprendizaje() {
        this.delegateUnidadAprendizaje = new DelegateUnidadAprendizaje();
    }

    public void guardarUnidadAprendizaje(UnidadAprendizaje up) throws IllegalArgumentException{
        validar(up);
        delegateUnidadAprendizaje.saveUnidadAprendizaje(up);
    }

    public void eliminarUnidadAprendizaje(Integer id) {
        delegateUnidadAprendizaje.deleteUnidadAprendizaje(id);
    }

    public void actualizarUnidad(UnidadAprendizaje up) throws IllegalArgumentException{
        validar(up);
        delegateUnidadAprendizaje.updateUnidadAprendizaje(up);
    }

    public void buscarUnidadPorId(Integer id) {
        delegateUnidadAprendizaje.getUnidad(id);
    }

    public List<UnidadAprendizaje> obtenerUnidades(){
        return delegateUnidadAprendizaje.getUnidades();
    }

    private void validar(UnidadAprendizaje unidad) {
        String nombreUp = unidad.getNombreUp();

        if (nombreUp == null || nombreUp.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (nombreUp.length() > 50) {
            throw new IllegalArgumentException("El nombre no puede superar los 50 caracteres");
        }
        if (unidad.getHorasClase() < 0 || unidad.getHorasClase() > 4) {
            throw new IllegalArgumentException("Horas de clase deben estar entre 0 y 4");
        }
        if (unidad.getHorasTaller() < 0 || unidad.getHorasTaller() > 4) {
            throw new IllegalArgumentException("Horas de taller deben estar entre 0 y 4");
        }
        if (unidad.getHorasLaboratorio() < 0 || unidad.getHorasLaboratorio() > 4) {
            throw new IllegalArgumentException("Horas de laboratorio deben estar entre 0 y 4");
        }
    }

    public Optional<UnidadAprendizaje> obtenerUnidadPorID(Integer id) {
        return delegateUnidadAprendizaje.getUnidad(id);
    }
}