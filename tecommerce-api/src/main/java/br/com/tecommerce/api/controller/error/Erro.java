package br.com.tecommerce.api.controller.error;

public class Erro {

    String mensagem;

    public Erro() {}

    public Erro(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }


}
