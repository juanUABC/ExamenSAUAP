package macrocombo.sauap.delegate;

import macrocombo.sauap.entity.Asigna;
import macrocombo.sauap.integration.ServiceLocator;

import java.util.List;

public class DelegateAsigna {

    public void saveAsigna(Asigna asigna){
        ServiceLocator.getInstanceAsignaDAO().save(asigna);
    }

    public List<Asigna> obtenerTodasAsignaciones() {
        return ServiceLocator.getInstanceAsignaDAO().obtenerTodasAsignaciones();
    }

    public boolean existeTraslape(Asigna asigna) {
        return ServiceLocator.getInstanceAsignaDAO().existeTraslape(asigna);
    }
}
