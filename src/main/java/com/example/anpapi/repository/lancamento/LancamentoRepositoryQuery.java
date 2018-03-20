package com.example.anpapi.repository.lancamento;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.anpapi.model.Lancamento;
import com.example.anpapi.repository.filter.LancamentoFilter;
import com.example.anpapi.repository.projection.ResumoLancamento;

public interface LancamentoRepositoryQuery {
	
	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
	public Page<ResumoLancamento> resumoLancamento(LancamentoFilter lancamentoFilter, Pageable pageable);

}
