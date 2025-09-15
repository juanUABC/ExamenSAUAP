package macrocombo.sauap.integration;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;
import macrocombo.sauap.entity.Profesor;

@FacesValidator("rfcValidator")
public class RfcValidador implements Validator<String> {

    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
        // 1. Validar formato básico RFC (persona física y moral)
        String regex = "^[A-ZÑ&]{3,4}\\d{6}[A-Z0-9]{3}$";
        if (value == null || !value.matches(regex)) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "RFC inválido",
                            "El RFC no cumple con el formato requerido"));
        }

        // 2. Validar que el RFC no esté duplicado en la BD
        for (Profesor p : ServiceFacadeLocator.getInstanceFacadeProfesor().obtenerProfesores()) {
            if (p.getRfc().equalsIgnoreCase(value)) {
                throw new ValidatorException(
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "RFC duplicado",
                                "Ya existe un profesor con este RFC registrado"));
            }
        }
    }
}

