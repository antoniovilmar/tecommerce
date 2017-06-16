package br.com.tecommerce.application.dto;

public class ProdutoDadosBasicosDto {

	private String nome;
	private String descricao;
	private String valor;

	public ProdutoDadosBasicosDto() {

	}

	public ProdutoDadosBasicosDto(String nome, String descricao, String valor) {
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getNome() {
		return nome;
	}
	
	public String getValor() {
		return valor;
	}


}
