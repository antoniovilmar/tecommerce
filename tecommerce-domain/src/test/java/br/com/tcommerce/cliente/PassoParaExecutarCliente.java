package br.com.tcommerce.cliente;

import org.junit.Assert;

import br.com.tcommerce.basetest.BaseTest;
import br.com.tcommerce.domain.cliente.Cliente;
import br.com.tecommerce.domain.types.Cpf;
import br.com.tecommerce.domain.types.Data;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PassoParaExecutarCliente extends BaseTest {

	private Data dataNascimento;
	private Cpf cpf;
	private String nome;
	private Cliente cliente;
	private Exception exceptionRecebida;

	@Dado("^que informo o nome \"([^\"]*)\"$")
	public void que_informo_o_nome(String nome) throws Throwable {
		this.nome = nome;
	}

	@Dado("^informo a data de nascimento \"([^\"]*)\"$")
	public void informo_a_data_de_nascimento(String data) throws Throwable {
		this.dataNascimento = Data.instance(data);
	}

	@Dado("^informo o CPF \"([^\"]*)\"$")
	public void informo_o_CPF(String cpf) throws Throwable {
		this.cpf = Cpf.instance(cpf);
	}

	@Quando("^criar um cliente$")
	public void criar_um_cliente() throws Throwable {
		try {
			this.cliente = new Cliente.ClienteBuilder()
						.comCpf(this.cpf)
						.comNome(this.nome)
						.comDataNascimento(this.dataNascimento)
						.instance();	
		} catch (Exception e) {
			this.exceptionRecebida = e;
		}
		
	}

	@Entao("^devo ter um cliente valido$")
	public void devo_ter_um_cliente_valido() throws Throwable {
		Assert.assertNotNull(this.cliente);
		Assert.assertEquals(this.dataNascimento, this.cliente.getDataNascimento());
		Assert.assertEquals(this.cpf, this.cliente.getCpf());
		Assert.assertEquals(this.nome, this.cliente.getNome());
	}

	@Entao("^devo rececer a mensagem de erro \"([^\"]*)\" para \"([^\"]*)\"$")
	public void devo_rececer_a_mensagem_de_erro_para(String mensagemEsperada, String atributoEsperado) throws Throwable {
		Assert.assertTrue(isContemMensagemEsperada(atributoEsperado, mensagemEsperada, exceptionRecebida.getMessage()));
	}
	
}
