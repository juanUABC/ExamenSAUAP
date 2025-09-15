import macrocombo.sauap.dao.AsignaDAO;
import macrocombo.sauap.dao.ProfesorDAO;
import macrocombo.sauap.dao.UnidadAprendizajeDAO;
import macrocombo.sauap.entity.Asigna;
import macrocombo.sauap.entity.UnidadAprendizaje;
import macrocombo.sauap.persistence.HibernateUtil;
import macrocombo.sauap.entity.Profesor;

import java.util.List;

public class testDAO {
    public static void main(String[] args) {
        ProfesorDAO profesorDAO = new ProfesorDAO(HibernateUtil.getEntityManager());
        UnidadAprendizajeDAO unidadAprendizajeDAO = new UnidadAprendizajeDAO(HibernateUtil.getEntityManager());
        AsignaDAO asignaDAO = new AsignaDAO(HibernateUtil.getEntityManager());
        for (Profesor profe : profesorDAO.findAll()) {
            System.out.println(profe + "|| id [" + profe.getId()+ "]");
        }

        for (UnidadAprendizaje ua : unidadAprendizajeDAO.obtenerTodos()) {
            System.out.println(ua + " || id [" + ua.getId() + "]");
        }

        for (Asigna asigna : asignaDAO.findAll()) {
            System.out.println(asigna + "|| id [" + asigna.getId() + "]");
        }
    }
}