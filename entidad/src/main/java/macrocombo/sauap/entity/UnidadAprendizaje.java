package macrocombo.sauap.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "unidad_aprendizaje", schema = "asignacionua")
public class UnidadAprendizaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_unidad", nullable = false)
    private Integer id;

    @Size(max = 150)
    @NotNull
    @Column(name = "nombre_UP", nullable = false, length = 150)
    private String nombreUp;

    @NotNull
    @Column(name = "horas_clase", nullable = false)
    private Integer horasClase;

    @NotNull
    @Column(name = "horas_laboratorio", nullable = false)
    private Integer horasLaboratorio;

    @NotNull
    @Column(name = "horas_taller", nullable = false)
    private Integer horasTaller;

    @OneToMany(mappedBy = "idUnidad")
    private Set<Asigna> asignas = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreUp() {
        return nombreUp;
    }

    public void setNombreUp(String nombreUp) {
        this.nombreUp = nombreUp;
    }

    public Integer getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(Integer horasClase) {
        this.horasClase = horasClase;
    }

    public Integer getHorasLaboratorio() {
        return horasLaboratorio;
    }

    public void setHorasLaboratorio(Integer horasLaboratorio) {
        this.horasLaboratorio = horasLaboratorio;
    }

    public Integer getHorasTaller() {
        return horasTaller;
    }

    public void setHorasTaller(Integer horasTaller) {
        this.horasTaller = horasTaller;
    }

    public Set<Asigna> getAsignas() {
        return asignas;
    }

    public void setAsignas(Set<Asigna> asignas) {
        this.asignas = asignas;
    }

}