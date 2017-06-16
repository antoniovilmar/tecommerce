package br.com.tecommerce.application.dto;

public class ProdutoDto {
	
	private String nome;
	private  String descricao;
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getNome() {
		return nome;
	}

}
