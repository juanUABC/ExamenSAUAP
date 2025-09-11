package macrocombo.sauap.facade;

import macrocombo.sauap.delegate.DelegateProfesor;
import macrocombo.sauap.entity.Profesor;

public class FacadeProfesor {

    private final DelegateProfesor delegateProfesor;

    public FacadeProfesor() {
        this.delegateProfesor = new DelegateProfesor();
    }

    public void guardarProfesor(Profesor profe){
        delegateProfesor.saveProfesor(profe);
    }

}