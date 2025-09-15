package ui;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import macrocombo.sauap.entity.Asigna;
import macrocombo.sauap.integration.ServiceFacadeLocator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("consultaGeneralBeanUI")
@ViewScoped
public class ConsultaGeneralBeanUI implements Serializable {
    private List<Asigna> asignaciones;

    @PostConstruct
    public void init() {
        cargarAsignaciones();
    }

    public void cargarAsignaciones() {
        try {
            asignaciones = ServiceFacadeLocator.getInstanceFacadeAsigna()
                    .obtenerTodasAsignaciones();

            if (asignaciones == null) {
                asignaciones = new ArrayList<>();
            }
        } catch (Exception e) {
            e.printStackTrace();
            asignaciones = new ArrayList<>();
        }
    }

    // Pa refresca pq sin refrescado no hace na' :c
    public void refresh() {
        cargarAsignaciones();
    }

    // gs
    public List<Asigna> getAsignaciones() {
        if (asignaciones == null) {
            asignaciones = new ArrayList<>();
        }
        return asignaciones;
    }

    public void setAsignaciones(List<Asigna> asignaciones) {
        this.asignaciones = asignaciones;
    }
}
