package com.example.anpapi.repository.produto;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.anpapi.model.Produto;
import com.example.anpapi.repository.filter.ProdutoFilter;

public interface ProdutoRepositoryQuery {
	
	public Page<Produto> filtrar(ProdutoFilter produtoFilter, Pageable pageable);

}
