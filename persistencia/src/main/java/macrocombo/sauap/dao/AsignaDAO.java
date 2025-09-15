package macrocombo.sauap.dao;

import jakarta.persistence.EntityManager;
import macrocombo.sauap.entity.Asigna;
import macrocombo.sauap.persistence.AbstractDAO;

import java.util.List;

public class AsignaDAO extends AbstractDAO<Asigna> {
    private final EntityManager entityManager;

    public AsignaDAO(EntityManager em) {
        super(Asigna.class);
        this.entityManager = em;
    }

    public List<Asigna> obtenerTodasAsignaciones() {
        return entityManager
                .createQuery(
                        "SELECT a FROM Asigna a " +
                                "LEFT JOIN FETCH a.idProfesor p " +
                                "LEFT JOIN FETCH a.idUnidad u " +
                                "ORDER BY a.idProfesor.nombreProfesor ASC",
                        Asigna.class)
                .getResultList();
    }

    public boolean existeTraslape(Asigna nueva) {
        String jpql = "SELECT COUNT(a) FROM Asigna a " +
                "WHERE a.idProfesor = :profesor " +
                "AND a.diaSemana = :dia " +
                "AND (:horaInicio < a.horaFin AND :horaFin > a.horaInicio)";

        Long count = entityManager.createQuery(jpql, Long.class)
                .setParameter("profesor", nueva.getIdProfesor())
                .setParameter("dia", nueva.getDiaSemana())
                .setParameter("horaInicio", nueva.getHoraInicio())
                .setParameter("horaFin", nueva.getHoraFin())
                .getSingleResult();

        return count > 0;
    }


    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}

