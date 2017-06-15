package br.com.tcommerce.produto;

import org.junit.Assert;

import br.com.tcommerce.basetest.BaseTest;
import br.com.tcommerce.domain.produto.Produto;
import br.com.tecommerce.domain.types.Moeda;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PassoParaExecutarProduto extends BaseTest {

	private String descricao;
	private String nome;
	private Moeda valorVenda;
	private Produto produto;
	private Exception exceptionRecebida;

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
		try {
			this.produto = new Produto.ProdutoBuilder().comDescricao(this.descricao).comNome(this.nome).comValor(this.valorVenda).instance();	
		} catch (Exception e) {
			exceptionRecebida = e;
		}
		
	}

	@Dado("^que nao informo os dados obrigatorios para a criacao de um produto$")
	public void que_nao_informo_os_dados_obrigatorios_para_a_criacao_de_um_produto() throws Throwable {
		this.descricao = null;
		this.nome = null;
		this.valorVenda = null;
	}

	@Entao("^devo ter o mesmo criado$")
	public void devo_ter_o_mesmo_criado() throws Throwable {
		Assert.assertNotNull(produto);
		Assert.assertEquals(this.descricao, produto.getDescricao());
		Assert.assertEquals(this.nome, produto.getNome());
		Assert.assertEquals(this.valorVenda, produto.getValor());
	}

	@Entao("^devo rececer a mensagem de erro \"([^\"]*)\" para \"([^\"]*)\"$")
	public void devo_rececer_a_mensagem_de_erro_para(String mensagemEsperada, String atributoEsperado) throws Throwable {
		Assert.assertTrue(isContemMensagemEsperada(atributoEsperado, mensagemEsperada, exceptionRecebida.getMessage()));
	}

}
