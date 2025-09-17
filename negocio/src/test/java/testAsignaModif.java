
import macrocombo.sauap.integration.ServiceFacadeLocator;
import macrocombo.sauap.integration.ServiceLocator;
import macrocombo.sauap.dao.AsignaDAO;
import macrocombo.sauap.entity.Asigna;

public class testAsignaModif {
    public static void main(String[] args) {
        System.out.println("Prueba de modificacion de asignaciones!!!!!");

        AsignaDAO asignaDao = ServiceLocator.getInstanceAsignaDAO();
        Asigna asigna = asignaDao.obtenerTodasAsignaciones().getFirst();

        try {
            System.out.println(asigna.getIdProfesor() + " : antes : " +  asigna.getIdUnidad());
            ServiceFacadeLocator.getInstanceFacadeAsigna().modificarAsigna(asigna, 2, 2);
            System.out.println(asigna.getIdProfesor() + " : despues : " +  asigna.getIdUnidad());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
