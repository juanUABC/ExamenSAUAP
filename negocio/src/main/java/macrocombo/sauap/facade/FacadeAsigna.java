package macrocombo.sauap.facade;

import macrocombo.sauap.delegate.DelegateAsigna;
import macrocombo.sauap.entity.Asigna;
import macrocombo.sauap.entity.Profesor;
import macrocombo.sauap.entity.UnidadAprendizaje;
import macrocombo.sauap.integration.ServiceFacadeLocator;

import java.util.List;
import java.util.Optional;

public class FacadeAsigna {

    private final DelegateAsigna delegateAsigna;

    public FacadeAsigna() {
        this.delegateAsigna = new DelegateAsigna();
    }

    public void guardarAsigna(Asigna asigna, Integer idProfesor, Integer idUnidad){
        validarDatos(asigna, idProfesor, idUnidad);
        validarTraslape(asigna);
        delegateAsigna.saveAsigna(asigna);
    }

    public void modificarAsigna(Asigna asigna, Integer idProfesor, Integer idUnidad){
        validarDatos(asigna, idProfesor, idUnidad);
        validarTraslape(asigna);
        delegateAsigna.updateAsigna(asigna);
    }

    public void eliminar(Asigna asigna) {
        delegateAsigna.deleteAsigna(asigna);
    }

    public List<Asigna> obtenerTodasAsignaciones() {
        return delegateAsigna.obtenerTodasAsignaciones();
    }

    public Asigna obtenerPorID(Integer id) {
        return this.delegateAsigna.getPorID(id);
    }

    private void validarDatos(Asigna asigna, Integer idProfesor, Integer idUnidad) {
        final String str = "No se selecciono ningun";
        if (idProfesor == null) {
            throw new IllegalArgumentException(str + " profesor");
        }
        if (idUnidad == null) {
            throw new IllegalArgumentException(str + "a unidad de aprendizaje");
        }

        Optional<Profesor> optionalProfesor = ServiceFacadeLocator.getInstanceFacadeProfesor().obtenerProfesorPorID(idProfesor);
        Optional<UnidadAprendizaje> optionalUnidadAprendizaje = ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().obtenerUnidadPorID(idUnidad);

        if (optionalProfesor.isEmpty()) {
            throw new IllegalArgumentException("Profesor no encontrado con ID: " + idProfesor);
        }
        Profesor profesor = optionalProfesor.get();

        if (optionalUnidadAprendizaje.isEmpty()) {
            throw new IllegalArgumentException("Unidad de Aprendizaje no encontrada con ID: " + idUnidad);
        }
        UnidadAprendizaje unidad = optionalUnidadAprendizaje.get();

        if(asigna == null) {
            throw new IllegalArgumentException("Asigna no inicializado");
        }

        if(asigna.getHoraFin().isBefore(asigna.getHoraInicio())){
            throw new IllegalArgumentException("Horario invalido");
        }

        asigna.setIdUnidad(unidad);
        asigna.setIdProfesor(profesor);
    }

    private void validarTraslape(Asigna asigna) {
        if(delegateAsigna.existeTraslape(asigna))
            throw new IllegalArgumentException("Hora horario se traslapa");
    }
}