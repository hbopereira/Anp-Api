package com.example.anpapi.repository.lancamento;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.anpapi.dto.LancamentoEstatisticaCategoria;
import com.example.anpapi.dto.LancamentoEstatisticaDia;
import com.example.anpapi.dto.LancamentoEstatisticaOcorrencia;
import com.example.anpapi.model.Lancamento;
import com.example.anpapi.repository.filter.LancamentoFilter;
import com.example.anpapi.repository.projection.ResumoLancamento;

public interface LancamentoRepositoryQuery {
	
	public List<LancamentoEstatisticaCategoria> porCategoria(LocalDate mesReferencia);
	public List<LancamentoEstatisticaOcorrencia> porOcorrencia(LocalDate mesReferencia);
	public List<LancamentoEstatisticaDia> porDia(LocalDate mesReferencia);
	
	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
	public Page<ResumoLancamento> resumoLancamento(LancamentoFilter lancamentoFilter, Pageable pageable);

}
