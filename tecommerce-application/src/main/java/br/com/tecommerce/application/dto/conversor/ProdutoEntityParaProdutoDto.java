package br.com.tecommerce.application.dto.conversor;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.tcommerce.domain.produto.Produto;
import br.com.tecommerce.application.dto.ProdutoDto;

@Component
public class ProdutoEntityParaProdutoDto implements Function<Produto, ProdutoDto> {

	@Override
	public ProdutoDto apply(Produto produtoEntity) {
		return new ProdutoDto(produtoEntity.getNome(), produtoEntity.getDescricao(), produtoEntity.getId(),
				produtoEntity.getValor().getValorFormatadoComMascara());
	}

}
