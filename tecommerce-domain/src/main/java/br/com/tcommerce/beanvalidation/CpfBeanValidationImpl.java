package br.com.tcommerce.beanvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

public class CpfBeanValidationImpl implements ConstraintValidator<Cpf, String> {

	private static final int[] pesoCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

	public CpfBeanValidationImpl() {
	}

	@Override
	public void initialize(Cpf value) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isBlank(value)) {
			return true;
		}
		return validarCPF(value);
	}

	private Boolean validarCPF(String cpf) {
		if (StringUtils.isBlank(cpf)) {
			return true;
		}
		cpf = removerMascara(cpf);
		if ((cpf.length() != 11) || validarSequenciaCaracter(cpf)) {
			return false;
		}
		Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
		Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
		return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
	}

	private static int calcularDigito(String str, int[] peso) {
		int soma = 0;
		for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
			digito = Integer.parseInt(str.substring(indice, indice + 1));
			soma += digito * peso[peso.length - str.length() + indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}

	private Boolean validarSequenciaCaracter(String documento) {
		String documentoTemp;
		for (int i = 0; i <= 9; i++) {
			documentoTemp = "";
			for (int j = 0; j < 11; j++) {
				documentoTemp += i;
			}
			if (documento.equals(documentoTemp)) {
				return true;
			}
		}
		return false;
	}

	private String removerMascara(String cpf) {
		if (StringUtils.isBlank(cpf)) {
			return null;
		}
		String cpfSemPontos = cpf;
		cpfSemPontos = cpfSemPontos.replace(".", "");
		cpfSemPontos = cpfSemPontos.replace("-", "");
		cpfSemPontos = cpfSemPontos.replace(" ", "");
		return cpfSemPontos;
	}

}
