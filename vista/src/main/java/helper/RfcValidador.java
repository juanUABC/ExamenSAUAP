package helper;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;
import macrocombo.sauap.entity.Profesor;
import macrocombo.sauap.integration.ServiceFacadeLocator;

import java.util.regex.Pattern;
@FacesValidator("rfcValidator")
public class RfcValidador implements Validator<String> {

    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
        String regex = "^[A-ZÑ&]{4}\\d{6}[A-Z0-9]{3}$";
        if (value != null) {
            value = value.toUpperCase();
        }

        if (value == null || !value.matches(regex)) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "RFC inválido",
                            "El RFC no cumple con el formato requerido"));
        }

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