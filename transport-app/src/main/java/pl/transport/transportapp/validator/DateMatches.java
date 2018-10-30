package pl.transport.transportapp.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateMatchesValidator.class)
public @interface DateMatches {
    String message() default "only YYYY-MM-DD";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
