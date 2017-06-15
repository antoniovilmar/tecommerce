package br.com.tcommerce.beanvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MoedaBeanValidationImpl implements ConstraintValidator<Moeda, br.com.tecommerce.domain.types.Moeda> {

	@Override
	public void initialize(Moeda value) {
	}

	@Override
	public boolean isValid(br.com.tecommerce.domain.types.Moeda value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}
		return value.maiorZero();
	}

}
