package com.example.anpapi.repository.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.anpapi.model.TipoLancamento;

public class ResumoLancamento {
	
	private Long id;
	private String descricao;
	private LocalDate dataVencimento;
	private LocalDate dataEmissao;
	private LocalDate dataPagamento;
	private BigDecimal valor;
	private TipoLancamento tipoLancamento;
	private String categoria;
	private String pessoa;
	private String ocorrencia;
	
	public ResumoLancamento(Long id, String descricao, LocalDate dataVencimento, LocalDate dataEmissao, LocalDate dataPagamento,
			BigDecimal valor, TipoLancamento tipoLancamento, String categoria, String pessoa, String ocorrencia) {
		this.id = id;
		this.descricao = descricao;
		this.dataVencimento = dataVencimento;
		this.dataEmissao = dataEmissao;
		this.dataPagamento = dataPagamento;
		this.valor = valor;
		this.tipoLancamento = tipoLancamento;
		this.categoria = categoria;
		this.pessoa = pessoa;
		this.ocorrencia = ocorrencia;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	public LocalDate getDataPagamento() {
		return dataPagamento;
	}
	
	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}
	
	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}

	public String getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	
	
	
	

}
