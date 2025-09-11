package macrocombo.sauap.delegate;

import macrocombo.sauap.entity.Administrador;
import macrocombo.sauap.integration.ServiceLocator;

import java.util.List;

public class DelegateAdministrador {
    public Administrador login(String password, String nombre){
        Administrador administrador = new Administrador();
        List<Administrador> administradors = ServiceLocator.getInstanceAdministradorDAO().findAll();

        for(Administrador admin:administradors){
            if(admin.getContrasena().equals(password) && admin.getNombreUsuario().equalsIgnoreCase(nombre)){
                administrador = admin;
            }
        }
        return administrador;
    }

    public void saveUsario(Administrador administrador){
        ServiceLocator.getInstanceAdministradorDAO().save(administrador);
    }

}