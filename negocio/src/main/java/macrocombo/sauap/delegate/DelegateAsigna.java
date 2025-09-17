package macrocombo.sauap.delegate;

import macrocombo.sauap.entity.Asigna;
import macrocombo.sauap.integration.ServiceLocator;
import macrocombo.sauap.persistence.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

import java.util.List;

public class DelegateAsigna {
    public void saveAsigna(Asigna asigna){
        ServiceLocator.getInstanceAsignaDAO().save(asigna);
    }
    public void updateAsigna(Asigna asigna){ServiceLocator.getInstanceAsignaDAO().update(asigna);}
    public void deleteAsigna(Asigna asigna){ServiceLocator.getInstanceAsignaDAO().delete(asigna);}

    public Asigna getPorID(Integer id) {
        EntityManager em = HibernateUtil.getEntityManager();
        return em.find(Asigna.class, id);
    }

    public List<Asigna> obtenerTodasAsignaciones() {
        return ServiceLocator.getInstanceAsignaDAO().obtenerTodasAsignaciones();
    }

    public boolean existeTraslape(Asigna asigna) {
        return ServiceLocator.getInstanceAsignaDAO().existeTraslape(asigna);
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