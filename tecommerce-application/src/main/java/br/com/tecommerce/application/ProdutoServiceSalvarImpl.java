package br.com.tecommerce.application;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import br.com.tcommerce.domain.produto.Produto;
import br.com.tecommerce.application.dto.ProdutoDto;
import br.com.tecommerce.domain.types.Moeda;
import br.com.tecommerce.repository.ProdutoRepository;

@Component
public class ProdutoServiceSalvarImpl implements ProdutoServiceSalvar {

	@Inject
	private ProdutoRepository repository;

	@Override
	public void salvar(ProdutoDto produtoDto) {
		final Produto produto = new Produto.ProdutoBuilder()
				 					.comDescricao(produtoDto.getDescricao())
				 					.comValor(Moeda.instance("10"))
				 					.comNome(produtoDto.getNome()).instance();
		repository.save(produto);

	}

}
