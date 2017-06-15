package br.com.tcommerce.domain;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public abstract class BaseEntity {
	
	private Integer id;
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		BaseEntity alvoComparacao = (BaseEntity) obj;
		return new EqualsBuilder().append(getId(), alvoComparacao.getId()).isEquals();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public final void isValid() {
		Configuration<?> config = Validation.byDefaultProvider().configure();
		ValidatorFactory factory = config.buildValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<BaseEntity>> violations = validator.validate(this);

		Set<String> violationMessages = new HashSet<String>();

		for (ConstraintViolation<BaseEntity> constraintViolation : violations) {
			String campo = StringUtils.capitalize(constraintViolation.getPropertyPath().toString());
			String msg = constraintViolation.getMessage();
			violationMessages.add(campo.concat(" : ").concat(msg));
		}

		if (!violationMessages.isEmpty()) {
			throw new DomainBusinessException(StringUtils.join(violationMessages, " \n "));
		}
	}
	
	public Integer getId() {
		return id;
	}

}
