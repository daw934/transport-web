package pl.transport.transportapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, String> {

    private String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
            return Pattern.matches(pattern,s);
    }

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }
}
