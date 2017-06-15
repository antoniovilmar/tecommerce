package br.com.tcommerce.beanvalidation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = MoedaBeanValidationImpl.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Moeda {

  String message() default "{valor.moeda.invalido}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
