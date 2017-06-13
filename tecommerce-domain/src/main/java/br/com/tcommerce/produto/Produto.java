package br.com.tcommerce.produto;

import br.com.tecommerce.domain.types.Moeda;

public class Produto {

	private String nome;
	private String descricao;
	private Moeda valor;

	public Produto(String nome, String descricao, Moeda valor) {
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Moeda getValor() {
		return valor;
	}

}
