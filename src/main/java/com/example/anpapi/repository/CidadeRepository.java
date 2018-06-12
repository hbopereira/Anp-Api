package com.example.anpapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.anpapi.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
	public List<Cidade> findByEstadoId(Long estadoId);

}
