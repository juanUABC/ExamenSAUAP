import macrocombo.sauap.dao.AdministradorDAO;
import macrocombo.sauap.entity.Administrador;
import macrocombo.sauap.integration.ServiceFacadeLocator;
import macrocombo.sauap.integration.ServiceLocator;

public class testLogin {
    public static void main(String[] args) {
        AdministradorDAO adminDAO = ServiceLocator.getInstanceAdministradorDAO();
        Administrador admin = adminDAO.obtenerTodos().getFirst();

        Administrador testPasado = ServiceFacadeLocator.getInstanceFacadeAdministrador().login(admin.getContrasena(),admin.getNombreUsuario());
        System.out.println(testPasado.getNombreUsuario());
        try{
            String usuarioGigante = "A".repeat(51);
            String contrasenaGigante = "B".repeat(51);
            Administrador testFallado = ServiceFacadeLocator.getInstanceFacadeAdministrador().login(contrasenaGigante, usuarioGigante);
            System.out.println(testFallado.getNombreUsuario());

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
