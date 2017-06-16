package br.com.tecommerce.application;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import br.com.tcommerce.domain.produto.Produto;
import br.com.tecommerce.application.dto.ProdutoDadosBasicosDto;
import br.com.tecommerce.application.dto.conversor.ProdutoDadosBasicosDtoParaProdutoEntity;
import br.com.tecommerce.repository.ProdutoRepository;

@Component
public class ProdutoServiceSalvarImpl implements ProdutoServiceSalvar {

	private ProdutoRepository produtoRepository;
	private ProdutoDadosBasicosDtoParaProdutoEntity paraEntity;

	@Inject
	public ProdutoServiceSalvarImpl(ProdutoRepository produtoRepository,
			ProdutoDadosBasicosDtoParaProdutoEntity produtoDadosBasicosDtoParaProdutoEntity) {
		this.produtoRepository = produtoRepository;
		this.paraEntity = produtoDadosBasicosDtoParaProdutoEntity;
	}

	@Override
	public void salvar(ProdutoDadosBasicosDto produtoDadosBasicosDto) {
		final Produto produto = paraEntity.apply(produtoDadosBasicosDto);
		produtoRepository.save(produto);

	}

}
