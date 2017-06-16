package br.com.tecommerce.application;

import java.util.List;

import br.com.tecommerce.application.dto.ProdutoDto;

public interface ProdutoServiceConsultar {
	
	public ProdutoDto consultarPorId(final Long id);
	public List<ProdutoDto> listar();

}
