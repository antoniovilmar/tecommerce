package br.com.tecommerce.application;

import br.com.tecommerce.application.dto.ProdutoDto;

public interface ProdutoServiceConsultar {
	
	public ProdutoDto consultarPorId(Long id);

}
