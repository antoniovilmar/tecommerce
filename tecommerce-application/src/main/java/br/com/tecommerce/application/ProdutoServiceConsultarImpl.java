package br.com.tecommerce.application;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import br.com.tcommerce.domain.produto.Produto;
import br.com.tecommerce.application.dto.ProdutoDto;
import br.com.tecommerce.repository.ProdutoRepository;

@Component
public class ProdutoServiceConsultarImpl implements ProdutoServiceConsultar {
	
	@Inject
	private  ProdutoRepository produtoRepository;

	@Override
	public ProdutoDto consultarPorId(Long id) {
		
		Produto produto = produtoRepository.findOne(id);
		final ProdutoDto produtoDto = new ProdutoDto();
		produtoDto.setDescricao(produto.getDescricao());
		produtoDto.setNome(produto.getNome());
		
		return produtoDto;
		
	}

}
