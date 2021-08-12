package br.com.zup.edu.nossositedeviagens.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ValidaRotaUnicaValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RotaUnica {

    String message() default "Rota repetida";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

