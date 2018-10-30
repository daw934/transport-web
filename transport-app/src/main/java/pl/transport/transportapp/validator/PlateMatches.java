package pl.transport.transportapp.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.PARAMETER,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PlateMatchesValidator.class)
public @interface PlateMatches {
    String message() default "Plate don't match to plate in poland";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
