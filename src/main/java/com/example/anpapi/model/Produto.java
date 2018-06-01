package com.example.anpapi.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_tipo")
	private Tipo tipo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_unidade_medida")
	private UnidadeMedida unidadeMedida;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_grupo")
	private Grupo grupo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_sub_grupo")
	private Subgrupo subGrupo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_classe")
	private Classe classe;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_marca")
	private Marca marca;
	//@JsonIgnoreProperties("produto")
//	@Valid
	//@OneToMany(mappedBy = "produto", cascade=CascadeType.ALL,
	  //         orphanRemoval = true)
	//private List<Fornecedor> fornecedores;
	
	@Column(name="codigo_barras")
	private String codigoBarras;
	
	@Column(name="controla_estoque")
	private boolean controlaEstoque;
	
	@Column(name="estoque_minimo")
	private BigDecimal estoqueMinimo;
	
	@Column(name="estoque_maximo")
	private BigDecimal estoqueMaximo;
	
	@Column(name="ultimo_custo")
	private BigDecimal ultimoCusto;
	
	@Column(name="custo_medio")
	private BigDecimal custoMedio;
	
	@NotNull
	private String descricao;
	
	@NotNull
	private String aplicacao;
	
	@NotNull
	@Column(name="valor_unitario")
	private BigDecimal valorUnitario;
	
	@Column(name="data_cadastro")
	private String dataCadastro;
	
	@Column(name="data_modificacao")
	private String dataModificacao;
	
	private Boolean ativo;
	
	private String observacao;

	public Subgrupo getSubGrupo() {
		return subGrupo;
	}

	public void setSubGrupo(Subgrupo subGrupo) {
		this.subGrupo = subGrupo;
	}

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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

/*	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}*/

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public boolean isControlaEstoque() {
		return controlaEstoque;
	}

	public void setControlaEstoque(boolean controlaEstoque) {
		this.controlaEstoque = controlaEstoque;
	}

	public BigDecimal getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(BigDecimal estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public BigDecimal getEstoqueMaximo() {
		return estoqueMaximo;
	}

	public void setEstoqueMaximo(BigDecimal estoqueMaximo) {
		this.estoqueMaximo = estoqueMaximo;
	}

	public BigDecimal getUltimoCusto() {
		return ultimoCusto;
	}

	public void setUltimoCusto(BigDecimal ultimoCusto) {
		this.ultimoCusto = ultimoCusto;
	}

	public BigDecimal getCustoMedio() {
		return custoMedio;
	}

	public void setCustoMedio(BigDecimal custoMedio) {
		this.custoMedio = custoMedio;
	}

	public String getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(String aplicacao) {
		this.aplicacao = aplicacao;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(String dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	
	
	
	
	
	

    
	
	
	
	
	
	
	
	

}
