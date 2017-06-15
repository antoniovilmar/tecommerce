package br.com.tcommerce.domain;

public class DomainBusinessException extends RuntimeException {

	private static final long serialVersionUID = 2177767187126091149L;

	public DomainBusinessException(String mensagem) {
		super(mensagem);
	}

}
