package com.example.anpapi.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.anpapi.model.Categoria;
import com.example.anpapi.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository catRepo;
	
	public Categoria salvar(Categoria cat) {
		return catRepo.save(cat);
	}
	
	public Set<Categoria> buscarTodos(){
		return new HashSet<Categoria>(catRepo.findAll());
	}

}
