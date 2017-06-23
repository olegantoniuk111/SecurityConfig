package vin.gans.validation;

import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.TYPE,
        ElementType.FIELD,
        ElementType.ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidateEmailImpl.class)
@Documented
public @interface ValidateEmail{
    String message() default "Invalid Email";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

