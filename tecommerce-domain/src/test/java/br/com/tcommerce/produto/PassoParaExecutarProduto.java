package br.com.tcommerce.produto;

import org.junit.Assert;

import br.com.tecommerce.domain.types.Moeda;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PassoParaExecutarProduto {

	private String descricao;
	private String nome;
	private Moeda valorVenda;
	private Produto produto;

	@Dado("^que informo a descricao \"([^\"]*)\"$")
	public void que_informo_a_descricao(String descricao) throws Throwable {
		this.descricao = descricao;
	}

	@Dado("^informo o nome \"([^\"]*)\"$")
	public void informo_o_nome(String nome) throws Throwable {
		this.nome = nome;
	}

	@Dado("^informo o valor de venda de \"([^\"]*)\"$")
	public void informo_o_valor_de_venda_de(String valorVenda) throws Throwable {
		this.valorVenda = Moeda.instance(valorVenda);
	}

	@Quando("^criar um produto$")
	public void criar_um_produto() throws Throwable {
		this.produto = new Produto(nome, descricao, valorVenda);
	}

	@Entao("^devo ter o mesmo criado$")
	public void devo_ter_o_mesmo_criado() throws Throwable {
		Assert.assertNotNull(produto);
		Assert.assertEquals(this.descricao, produto.getDescricao());
		Assert.assertEquals(this.nome, produto.getNome());
		Assert.assertEquals(this.valorVenda, produto.getValor());
	}

}
