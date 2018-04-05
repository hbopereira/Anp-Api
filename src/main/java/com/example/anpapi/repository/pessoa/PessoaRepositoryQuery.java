package com.example.anpapi.repository.pessoa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.anpapi.model.Lancamento;
import com.example.anpapi.model.Pessoa;
import com.example.anpapi.repository.filter.LancamentoFilter;
import com.example.anpapi.repository.filter.PessoaFilter;

public interface PessoaRepositoryQuery {
	
	public Page<Pessoa> filtrar(PessoaFilter pessoaFilter, Pageable pageable);

}
