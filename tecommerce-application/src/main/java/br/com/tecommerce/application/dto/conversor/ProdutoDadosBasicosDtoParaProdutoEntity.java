package br.com.tecommerce.application.dto.conversor;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.tcommerce.domain.produto.Produto;
import br.com.tecommerce.application.dto.ProdutoDadosBasicosDto;
import br.com.tecommerce.domain.types.Moeda;

@Component
public class ProdutoDadosBasicosDtoParaProdutoEntity implements Function<ProdutoDadosBasicosDto, Produto> {

	@Override
	public Produto apply(ProdutoDadosBasicosDto produtoDto) {
		return new Produto.ProdutoBuilder()
				.comDescricao(produtoDto.getDescricao())
				.comNome(produtoDto.getNome())
				.comValor(Moeda.instance(produtoDto.getValor())).instance();
	}

}
