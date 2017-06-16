package br.com.tcommerce.domain.produto;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.tcommerce.domain.BaseEntity;
import br.com.tcommerce.domain.BuilderDominio;
import br.com.tecommerce.domain.types.Moeda;

@Entity
public class Produto extends BaseEntity {
	
	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(max = 100, message = "{tamanho.cemcaracteres.invalido}")
	private String nome;

	@NotNull
	@Size(max = 500, message = "{tamanho.quinhentoscaracteres.invalido}")
	private String descricao;

	@NotNull
	@br.com.tcommerce.beanvalidation.Moeda
	@Embedded
	private Moeda valor;

	protected Produto() {
		// protected para uso de framework de ORM
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
	
	public Long getId() {
		return id;
	}

	public static class ProdutoBuilder extends BuilderDominio<Produto> {

		private static final long serialVersionUID = 1L;

		private Produto produto;

		public ProdutoBuilder() {
			this.produto = new Produto();
		}

		@Override
		protected Produto getDominio() {
			return this.produto;
		}

		public ProdutoBuilder comDescricao(String descricao) {
			this.produto.descricao = descricao;
			return this;
		}

		public ProdutoBuilder comNome(String nome) {
			this.produto.nome = nome;
			return this;
		}

		public ProdutoBuilder comValor(Moeda valor) {
			this.produto.valor = valor;
			return this;
		}

	}

}
