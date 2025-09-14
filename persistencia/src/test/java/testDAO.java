import macrocombo.sauap.dao.ProfesorDAO;
import macrocombo.sauap.dao.UnidadAprendizajeDAO;
import macrocombo.sauap.entity.UnidadAprendizaje;
import macrocombo.sauap.persistence.HibernateUtil;
import macrocombo.sauap.entity.Profesor;

import java.util.List;

public class testDAO {
    public static void main(String[] args) {
        ProfesorDAO profesorDAO = new ProfesorDAO(HibernateUtil.getEntityManager());
        UnidadAprendizajeDAO uaDAO = new UnidadAprendizajeDAO(HibernateUtil.getEntityManager());

        for (Profesor profe : profesorDAO.findAll()) {
            System.out.println(profe + "|| id [" + profe.getId()+ "]");
        }

        for (UnidadAprendizaje ua : uaDAO.obtenerTodos()) {
            System.out.println(ua + " || id [" + ua.getId() + "]");
        }
    }
}