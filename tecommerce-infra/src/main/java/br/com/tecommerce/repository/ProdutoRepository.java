package br.com.tecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tcommerce.domain.produto.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {


}