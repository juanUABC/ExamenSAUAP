package macrocombo.sauap.dao;

import jakarta.persistence.EntityManager;
import macrocombo.sauap.entity.Administrador;
import macrocombo.sauap.persistence.AbstractDAO;

import java.util.List;


public class AdministradorDAO extends AbstractDAO<Administrador> {
    private final EntityManager entityManager;

    public AdministradorDAO(EntityManager em) {
        super(Administrador.class);
        this.entityManager = em;
    }

    public List<Administrador> obtenerTodos(){
        return entityManager
                .createQuery("SELECT a FROM Administrador a", Administrador.class)
                .getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}