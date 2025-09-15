package macrocombo.sauap.delegate;

import macrocombo.sauap.entity.Asigna;
import macrocombo.sauap.integration.ServiceLocator;
import macrocombo.sauap.persistence.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class DelegateAsigna {
    public void saveAsigna(Asigna asigna){
        ServiceLocator.getInstanceAsignaDAO().save(asigna);
    }
    public List<Asigna> getAllAsignaciones() {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            TypedQuery<Asigna> query = em.createQuery("SELECT a FROM Asigna a", Asigna.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}