package br.com.tecommerce.api.controller.error;

public class Erro {

    String mensagem;

    protected Erro() {}

    protected Erro(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

}
