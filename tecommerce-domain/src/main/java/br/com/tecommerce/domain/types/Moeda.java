package br.com.tecommerce.domain.types;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Moeda implements Serializable {

	private static final long serialVersionUID = -4924962785465147613L;
	@NotNull
	@Column(name = "valor")
	private BigDecimal valor;

	protected Moeda() {
	}

	private Moeda(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValorFormatado() {
		if (valor == null) {
			return null;
		}
		return valor.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal getValorComDigitos() {
		if (valor == null) {
			return null;
		}
		return valor.setScale(4, BigDecimal.ROUND_HALF_UP);
	}

	public void setValorComDigitos(BigDecimal valor) {
		this.valor = valor;
	}

	public String getValorFormatadoComMascara() {
		if (valor == null) {
			return null;
		}
		return aplicarMascaraMonetaria();
	}

	public Boolean maiorQue(Moeda valor) {
		return this.getValorFormatado().doubleValue() > valor.getValorFormatado().doubleValue();
	}

	public Boolean maiorIgualQue(Moeda valor) {
		return this.getValorFormatado().doubleValue() > valor.getValorFormatado().doubleValue()
				|| this.getValorFormatado().equals(valor.getValorFormatado());
	}

	public Boolean maiorZero() {
		return this.getValorFormatado().doubleValue() > 0;
	}

	public Boolean isZero() {
		return Moeda.zerada().getValorFormatado().equals(getValorFormatado());
	}

	public Boolean isValorNull() {
		return getValor() == null;
	}

	public Boolean menorQue(Moeda valor) {
		return this.getValorFormatado().doubleValue() < valor.getValorFormatado().doubleValue();
	}

	public Boolean menorIgualQue(Moeda valor) {
		return this.getValorFormatado().doubleValue() < valor.getValorFormatado().doubleValue()
				|| this.getValorFormatado().equals(valor.getValorFormatado());
	}

	public Boolean igual(Moeda valor) {
		return getValorFormatado().doubleValue() == valor.getValorFormatado().doubleValue();
	}

	public void somar(Moeda soma) {
		try {
			BigDecimal resultado = BigDecimal.ZERO;
			zerarValor();
			resultado = resultado.add(getValorComDigitos());
			resultado = resultado.add(soma.getValorComDigitos());
			setValor(resultado);
		} catch (NullPointerException n) {
			setValor(BigDecimal.ZERO);
		}
	}

	public void subtrair(Moeda subtrai) {
		try {
			BigDecimal resultado = BigDecimal.ZERO;
			zerarValor();
			resultado = resultado.add(getValorComDigitos());
			resultado = resultado.subtract(subtrai.getValorComDigitos());
			setValor(resultado);
		} catch (NullPointerException n) {
			setValor(BigDecimal.ZERO);
		}
	}

	public void multiplicar(Moeda multiplica) {
		try {
			BigDecimal resultado = BigDecimal.ZERO;
			zerarValor();
			resultado = resultado.add(getValorComDigitos());
			resultado = resultado.multiply(multiplica.getValorComDigitos());
			setValor(resultado);
		} catch (NullPointerException n) {
			setValor(BigDecimal.ZERO);
		}
	}

	public void multiplicar(Double multiplica) {
		try {
			BigDecimal resultado = BigDecimal.ZERO;
			zerarValor();
			resultado = resultado.add(getValorComDigitos());
			resultado = resultado.multiply(new BigDecimal(multiplica));
			setValor(resultado);
		} catch (NullPointerException n) {
			setValor(BigDecimal.ZERO);
		}
	}

	public void dividir(Moeda dividir) {
		BigDecimal resultado = BigDecimal.ZERO;
		zerarValor();
		try {
			resultado = resultado.add(getValorComDigitos());
			resultado = resultado.divide(dividir.getValorComDigitos(), MathContext.DECIMAL128);
			setValor(resultado);
		} catch (ArithmeticException a) {
			resultado = resultado.divide(dividir.getValorComDigitos(), RoundingMode.HALF_UP);
			setValor(resultado);
		} catch (NullPointerException n) {
			setValor(BigDecimal.ZERO);
		}
	}

	public void dividir(Integer divisor) {
		BigDecimal resultado = BigDecimal.ZERO;
		zerarValor();
		try {
			resultado = resultado.add(getValorComDigitos());
			resultado = resultado.divide(new BigDecimal(divisor), MathContext.DECIMAL128);
			setValor(resultado);
		} catch (ArithmeticException a) {
			resultado = resultado.divide(new BigDecimal(divisor));
			setValor(resultado);
		} catch (NullPointerException n) {
			setValor(BigDecimal.ZERO);
		}
	}

	public void dividir(Double divisor) {
		BigDecimal resultado = BigDecimal.ZERO;
		zerarValor();
		try {
			resultado = resultado.add(getValorComDigitos());
			resultado = resultado.divide(new BigDecimal(divisor), MathContext.DECIMAL128);
			setValor(resultado);
		} catch (ArithmeticException a) {
			resultado = resultado.divide(new BigDecimal(divisor));
			setValor(resultado);
		} catch (NullPointerException n) {
			setValor(BigDecimal.ZERO);
		}
	}

	public static Moeda zerada() {
		Moeda zero = new Moeda();
		zero.setValor(BigDecimal.ZERO);
		return zero;
	}

	public static Moeda instance() {
		return new Moeda();
	}

	public static Moeda instance(String valor) {
		if (valor == null || valor.isEmpty()) {
			return Moeda.zerada();
		}
		return new Moeda(new BigDecimal(valor));
	}

	public static Moeda instance(Double valor) {
		return new Moeda(new BigDecimal(valor));
	}

	public static Moeda instance(Integer valor) {
		return new Moeda(new BigDecimal(valor));
	}

	@Override
	public boolean equals(Object o) {
		if (getValorFormatado() != null && o != null) {
			Moeda temp = (Moeda) o;
			return getValorFormatado().equals(temp.getValorFormatado());
		}
		return false;
	}

	@Override
	public String toString() {
		return getValorFormatadoComMascara();
	}

	private void zerarValor() {
		if (this.valor == null) {
			this.valor = BigDecimal.ZERO;
		}
	}

	private String aplicarMascaraMonetaria() {
		valor.setScale(2, BigDecimal.ROUND_HALF_UP);
		DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("pt", "BR"));
		DecimalFormat df = new DecimalFormat("#,###,##0.00", dfs);
		return df.format(new Double(valor.toString()));
	}
}
