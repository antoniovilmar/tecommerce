package br.com.tcommerce.domain.cliente;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.tcommerce.domain.BaseEntity;
import br.com.tcommerce.domain.BuilderDominio;
import br.com.tecommerce.domain.types.Cpf;
import br.com.tecommerce.domain.types.Data;

public class Cliente extends BaseEntity {

	@NotNull
	@Size(max = 100, message = "{tamanho.cemcaracteres.invalido}")
	private String nome;
	
	@Valid
	@NotNull
	private Cpf cpf;
	
	@NotNull
	private Data dataNascimento;

	protected Cliente() {
	}

	public String getNome() {
		return nome;
	}

	public Cpf getCpf() {
		return cpf;
	}

	public Data getDataNascimento() {
		return dataNascimento;
	}

	
	public static class ClienteBuilder extends BuilderDominio<Cliente> {
		private static final long serialVersionUID = 1L;
		private Cliente cliente;

		public ClienteBuilder() {
			this.cliente = new Cliente();
		}

		@Override
		protected Cliente getDominio() {
			return this.cliente;
		}

		public ClienteBuilder comNome(String nome) {
			this.cliente.nome = nome;
			return this;
		}

		public ClienteBuilder comDataNascimento(Data dataNascimento) {
			this.cliente.dataNascimento = dataNascimento;
			return this;
		}

		public ClienteBuilder comCpf(Cpf cpf) {
			this.cliente.cpf = cpf;
			return this;
		}

	}

}
