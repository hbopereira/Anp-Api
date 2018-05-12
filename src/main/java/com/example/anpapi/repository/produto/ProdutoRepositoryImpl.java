package com.example.anpapi.repository.produto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.example.anpapi.model.Pessoa;
import com.example.anpapi.model.Pessoa_;
import com.example.anpapi.model.Produto;
import com.example.anpapi.model.Produto_;
import com.example.anpapi.repository.filter.PessoaFilter;
import com.example.anpapi.repository.filter.ProdutoFilter;

public class ProdutoRepositoryImpl implements ProdutoRepositoryQuery {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Page<Produto> filtrar(ProdutoFilter produtoFilter, Pageable pageable) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Produto> criteria = builder.createQuery(Produto.class);
		Root<Produto> root = criteria.from(Produto.class);
		
		
		// criando as restrições com where...
		Predicate[] predicates = criarRestricoes(produtoFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Produto> query = entityManager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		 return new PageImpl<>(query.getResultList(), pageable, total(produtoFilter));
	}

	
	private Long total(ProdutoFilter produtoFilter) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Produto> root = criteria.from(Produto.class);
		
		//criando as restrições com where..
		Predicate[] predicates = criarRestricoes(produtoFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return entityManager.createQuery(criteria).getSingleResult();
	}
	
	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}
	
	private Predicate[] criarRestricoes(ProdutoFilter produtoFilter, CriteriaBuilder builder,
			Root<Produto> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		// simula o where do sql
		if(!StringUtils.isEmpty(produtoFilter.getDescricao())) {
			predicates.add(builder.like(builder.lower(root.get(Produto_.descricao)), "%" + produtoFilter.getDescricao().toLowerCase() + "%"));
		}
	   
		return predicates.toArray(new Predicate[predicates.size()]);
	}



}
