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

    public List<Asigna> obtenerTodos(){
        return entityManager
                .createQuery("SELECT a FROM Asigna a", Asigna.class)
                .getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}