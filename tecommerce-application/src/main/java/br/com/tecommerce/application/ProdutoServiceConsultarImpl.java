package br.com.tecommerce.application;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import br.com.tcommerce.domain.produto.Produto;
import br.com.tecommerce.application.dto.ProdutoDto;
import br.com.tecommerce.application.dto.conversor.ProdutoEntityParaProdutoDto;
import br.com.tecommerce.repository.ProdutoRepository;

@Component
public class ProdutoServiceConsultarImpl implements ProdutoServiceConsultar {

	private ProdutoRepository produtoRepository;
	private ProdutoEntityParaProdutoDto paraProdutoDto;

	@Inject
	public ProdutoServiceConsultarImpl(ProdutoRepository produtoRepository,
			ProdutoEntityParaProdutoDto produtoEntityParaProdutoDto) {
		this.produtoRepository = produtoRepository;
		this.paraProdutoDto = produtoEntityParaProdutoDto;
	}

	@Override
	public ProdutoDto consultarPorId(Long id) {

		final Produto produto = produtoRepository.findOne(id);
		return paraProdutoDto.apply(produto);

	}

	@Override
	public List<ProdutoDto> listar() {
		return produtoRepository.findAll().stream().map(paraProdutoDto).collect(Collectors.toList());
	}

}
