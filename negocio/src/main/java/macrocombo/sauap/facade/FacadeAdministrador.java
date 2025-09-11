package macrocombo.sauap.facade;

import macrocombo.sauap.delegate.DelegateAdministrador;
import macrocombo.sauap.entity.Administrador;

public class FacadeAdministrador {

    private final DelegateAdministrador delegateAdministrador;

    public FacadeAdministrador() {
        this.delegateAdministrador = new DelegateAdministrador();
    }

    public Administrador login(String password, String nombre){
        return delegateAdministrador.login(password, nombre);
    }

    public void saveAdministrador(Administrador admin){
        delegateAdministrador.saveUsario(admin);
    }

}