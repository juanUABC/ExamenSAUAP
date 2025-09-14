package macrocombo.sauap.facade;

import macrocombo.sauap.delegate.DelegateAsigna;
import macrocombo.sauap.entity.Asigna;

import java.util.List;

public class FacadeAsigna {

    private final DelegateAsigna delegateAsigna;

    public FacadeAsigna() {
        this.delegateAsigna = new DelegateAsigna();
    }

    public void guardarAsigna(Asigna asigna){
        delegateAsigna.saveAsigna(asigna);
    }

    public List<Asigna> obtenerTodasAsignaciones() {
        return delegateAsigna.obtenerTodasAsignaciones();
    }
}
