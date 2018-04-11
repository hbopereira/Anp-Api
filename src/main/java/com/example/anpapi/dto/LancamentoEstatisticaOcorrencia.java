package com.example.anpapi.dto;

import java.math.BigDecimal;

import com.example.anpapi.model.Ocorrencia;

public class LancamentoEstatisticaOcorrencia {
	
	private Ocorrencia ocorrencia;
	private BigDecimal total;
	
	public LancamentoEstatisticaOcorrencia(Ocorrencia ocorrencia, BigDecimal total) {
		this.ocorrencia = ocorrencia;
		this.total = total;
	}

	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	
	
	
	

}
