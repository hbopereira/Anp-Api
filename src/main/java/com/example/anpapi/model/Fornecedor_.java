package com.example.anpapi.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Fornecedor.class)
public abstract class Fornecedor_ {

	public static volatile SingularAttribute<Fornecedor, String> telefone;
	public static volatile SingularAttribute<Fornecedor, Produto> produto;
	public static volatile SingularAttribute<Fornecedor, String> nome;
	public static volatile SingularAttribute<Fornecedor, Long> id;
	public static volatile SingularAttribute<Fornecedor, String> cnpj;
	public static volatile SingularAttribute<Fornecedor, String> email;

}

