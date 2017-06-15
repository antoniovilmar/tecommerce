package br.com.tcommerce.basetest;

import org.apache.commons.lang3.StringUtils;

public abstract class BaseTest {
	public Boolean isContemMensagemEsperada(String mensagemEsperada, String mensagemRecebida) {
		String[] mensagens = mensagemRecebida.split(" \n ");
		for (String m : mensagens) {
			if (StringUtils.containsIgnoreCase(m, mensagemEsperada)) {
				return false;
			}
		}
		return true;
	}

	public Boolean isContemMensagemEsperada(String atributo, String mensagemEsperada, String mensagemRecebida) {
		String[] mensagens = mensagemRecebida.split(" \n ");
		for (String m : mensagens) {
			if (StringUtils.containsIgnoreCase(m, atributo) && StringUtils.containsIgnoreCase(m, mensagemEsperada)) {
				return true;
			}
		}
		return false;
	}

}
