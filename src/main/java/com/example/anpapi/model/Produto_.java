package com.example.anpapi.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produto.class)
public abstract class Produto_ {

	public static volatile SingularAttribute<Produto, BigDecimal> estoqueMaximo;
	public static volatile SingularAttribute<Produto, Tipo> tipo;
	public static volatile SingularAttribute<Produto, Classe> classe;
	public static volatile SingularAttribute<Produto, Boolean> ativo;
	public static volatile SingularAttribute<Produto, String> observacao;
	public static volatile SingularAttribute<Produto, Boolean> controlaEstoque;
	public static volatile SingularAttribute<Produto, String> aplicacao;
	public static volatile SingularAttribute<Produto, Grupo> grupo;
	public static volatile SingularAttribute<Produto, BigDecimal> custoMedio;
	public static volatile SingularAttribute<Produto, String> descricao;
	public static volatile SingularAttribute<Produto, BigDecimal> valorUnitario;
	public static volatile SingularAttribute<Produto, Subgrupo> subGrupo;
	public static volatile SingularAttribute<Produto, String> dataModificacao;
	public static volatile SingularAttribute<Produto, Marca> marca;
	public static volatile SingularAttribute<Produto, UnidadeMedida> unidadeMedida;
	public static volatile SingularAttribute<Produto, BigDecimal> ultimoCusto;
	public static volatile SingularAttribute<Produto, Long> id;
	public static volatile SingularAttribute<Produto, String> codigoBarras;
	public static volatile SingularAttribute<Produto, BigDecimal> estoqueMinimo;
	public static volatile SingularAttribute<Produto, String> dataCadastro;

}

