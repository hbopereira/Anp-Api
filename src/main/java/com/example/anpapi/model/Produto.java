package com.example.anpapi.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@JsonIgnoreProperties("produto")
	@Valid
	@OneToMany(mappedBy = "produto", cascade=CascadeType.ALL,
	           orphanRemoval = true)
	private List<Fornecedor> fornecedores;
	
	@NotNull
	private String descricao;
	
	@NotNull
	@Column(name="valor_unitario")
	private BigDecimal valorUnitario;
	
	@NotNull
	private String marca;
	
	@NotNull
	private int quantidade;
	
	private String observacao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((fornecedores == null) ? 0 : fornecedores.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + quantidade;
		result = prime * result + ((valorUnitario == null) ? 0 : valorUnitario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (fornecedores == null) {
			if (other.fornecedores != null)
				return false;
		} else if (!fornecedores.equals(other.fornecedores))
			return false;
		if (id != other.id)
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (quantidade != other.quantidade)
			return false;
		if (valorUnitario == null) {
			if (other.valorUnitario != null)
				return false;
		} else if (!valorUnitario.equals(other.valorUnitario))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	

}
