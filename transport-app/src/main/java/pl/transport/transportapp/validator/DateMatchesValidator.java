package pl.transport.transportapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateMatchesValidator implements ConstraintValidator<DateMatches, String> {
   private static final String pattern ="\\d{4}-\\d{2}-\\d{2}";
//   private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
   @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
       if (s.matches(pattern)) {
           return true;
       }
        return false;
    }
}
