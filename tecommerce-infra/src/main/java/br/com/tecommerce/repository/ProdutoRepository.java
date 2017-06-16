package br.com.tecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.tcommerce.domain.produto.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {


}