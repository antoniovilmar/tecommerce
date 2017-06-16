package br.com.tecommerce.application.dto;

public class ProdutoDto extends ProdutoDadosBasicosDto {

	private Long id;
	private String valorFormatado;

	public ProdutoDto(String nome, String descricao, Long id, String valorFormatado) {
		super(nome, descricao, valorFormatado);
		this.id = id;
		this.valorFormatado = valorFormatado;
	}

	public Long getId() {
		return id;
	}

	public String getValorFormatado() {
		return valorFormatado;
	}

}
