package macrocombo.sauap.facade;

import macrocombo.sauap.delegate.DelegateUnidadAprendizaje;
import macrocombo.sauap.entity.UnidadAprendizaje;

public class FacadeUnidadAprendizaje {

    private final DelegateUnidadAprendizaje delegateUnidadAprendizaje;

    public FacadeUnidadAprendizaje() {
        this.delegateUnidadAprendizaje = new DelegateUnidadAprendizaje();
    }

    public void guardarUnidadAprendizaje(UnidadAprendizaje up) throws IllegalArgumentException{
        validar(up);
        delegateUnidadAprendizaje.saveUnidadAprendizaje(up);
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
}