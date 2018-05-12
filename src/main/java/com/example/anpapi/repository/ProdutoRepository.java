package com.example.anpapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.anpapi.model.Produto;
import com.example.anpapi.repository.produto.ProdutoRepositoryQuery;

public interface ProdutoRepository extends JpaRepository<Produto, Long>, ProdutoRepositoryQuery {

}
