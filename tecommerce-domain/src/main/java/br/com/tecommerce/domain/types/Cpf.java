package br.com.tecommerce.domain.types;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;

public class Cpf {

	private final String MASCARA = "###.###.###-##";

	@br.com.tcommerce.beanvalidation.Cpf
	@Size(max = 20)
	private String cpf;

	protected Cpf() {
	}

	private Cpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = removerMascara(cpf);
	}

	public String getCpfFormadado() {
		return aplicarMascaraCpf();
	}

	public static Cpf instance() {
		return new Cpf();
	}

	public static Cpf instance(String cpf) {
		return new Cpf(cpf);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cpf other = (Cpf) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	private String aplicarMascaraCpf() {
		try {
			if (StringUtils.isBlank(cpf.toString())) {
				return null;
			}
			MaskFormatter mf = null;
			mf = new MaskFormatter(MASCARA);
			mf.setValueContainsLiteralCharacters(false);
			return mf.valueToString(cpf);

		} catch (NullPointerException | ParseException ex) {
			return null;
		}
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
