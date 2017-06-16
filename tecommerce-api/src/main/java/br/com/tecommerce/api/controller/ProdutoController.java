package br.com.tecommerce.api.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecommerce.application.ProdutoServiceConsultar;
import br.com.tecommerce.application.ProdutoServiceSalvar;
import br.com.tecommerce.application.dto.ProdutoDadosBasicosDto;
import br.com.tecommerce.application.dto.ProdutoDto;

@RestController
public class ProdutoController {

	private ProdutoServiceSalvar produtoServiceSalvar;
	private ProdutoServiceConsultar produtoServiceConsultar;

	@Inject
	public ProdutoController(ProdutoServiceSalvar produtoServiceSalvar,
			ProdutoServiceConsultar produtoServiceConsultar) {
		this.produtoServiceConsultar = produtoServiceConsultar;
		this.produtoServiceSalvar = produtoServiceSalvar;
	}

	@RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
	public ProdutoDto consultarPorId(@PathVariable("id") Long id) {
		return produtoServiceConsultar.consultarPorId(id);
	}
	
	@RequestMapping(value = "/produto", method = RequestMethod.GET)
	public List<ProdutoDto> listar() {
		return produtoServiceConsultar.listar();
	}

	@RequestMapping(value = "/produto", method = RequestMethod.POST)
	public void salvar(@RequestBody ProdutoDadosBasicosDto produtoDadosBasicosDto) {
		produtoServiceSalvar.salvar(produtoDadosBasicosDto);
	}
}
