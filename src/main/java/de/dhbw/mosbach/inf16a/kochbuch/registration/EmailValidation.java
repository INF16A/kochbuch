package de.dhbw.mosbach.inf16a.kochbuch.registration;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Annika Schatz
 * @author Tobias Bloch
 * @author Irina Eurich
 * @author Endrit Çallaki
 */
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface EmailValidation {
    String message() default "Invalid email";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}
