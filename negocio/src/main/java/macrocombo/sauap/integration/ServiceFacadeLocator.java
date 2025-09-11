package macrocombo.sauap.integration;


import macrocombo.sauap.facade.FacadeProfesor;
import macrocombo.sauap.facade.FacadeAdministrador;
import macrocombo.sauap.facade.FacadeAsigna;
import macrocombo.sauap.facade.FacadeUnidadAprendizaje;

public class ServiceFacadeLocator {
    private static FacadeProfesor facadeProfesor;
    private static FacadeAsigna facadeAsigna;
    private static FacadeAdministrador facadeAdministrador;
    private static FacadeUnidadAprendizaje facadeUnidadAprendizaje;

    public static FacadeProfesor getInstanceFacadeProfesor() {
        if (facadeProfesor == null) {
            facadeProfesor = new FacadeProfesor();
            return facadeProfesor;
        } else {
            return facadeProfesor;
        }
    }

    public static FacadeAsigna getInstanceFacadeAsigna() {
        if (facadeAsigna == null) {
            facadeAsigna = new FacadeAsigna();
            return facadeAsigna;
        } else  {
            return facadeAsigna;
        }
    }

    public static FacadeAdministrador getInstanceFacadeAdministrador() {
        if (facadeAdministrador == null) {
            facadeAdministrador = new FacadeAdministrador();
            return facadeAdministrador;
        }  else  {
            return facadeAdministrador;
        }
    }

    public static FacadeUnidadAprendizaje getInstanceFacadeUnidadAprendizaje() {
        if (facadeUnidadAprendizaje == null) {
            facadeUnidadAprendizaje = new FacadeUnidadAprendizaje();
            return facadeUnidadAprendizaje;
        } else  {
            return facadeUnidadAprendizaje;
        }
    }
}