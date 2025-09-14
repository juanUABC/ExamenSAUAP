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


    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}

