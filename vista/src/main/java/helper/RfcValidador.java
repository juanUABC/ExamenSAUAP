package helper;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

import java.util.regex.Pattern;

@FacesValidator("rfcValidator")
public class RfcValidador implements Validator<Object> {

    // Regex para validar RFC de personas físicas o morales
    private static final String RFC_PATTERN = "^[A-ZÑ&]{3,4}\\d{6}[A-Z0-9]{3}$";

    private static final Pattern pattern = Pattern.compile(RFC_PATTERN);

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            return; // El campo puede ser obligatorio en otro lado
        }

        String rfc = value.toString().toUpperCase();

        if (!pattern.matcher(rfc).matches()) {
            FacesMessage msg = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "RFC inválido",
                    "El RFC no cumple con el formato correcto"
            );
            throw new ValidatorException(msg);
        }
    }
}
