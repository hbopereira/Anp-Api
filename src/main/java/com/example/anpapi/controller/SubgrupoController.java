package com.example.anpapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.anpapi.model.Grupo;
import com.example.anpapi.model.Subgrupo;
import com.example.anpapi.repository.SubgrupoRepository;

@RestController
@RequestMapping("/subgrupos")
public class SubgrupoController {
	
	@Autowired
	private SubgrupoRepository subGrupoRepo;
	
	@GetMapping
	public List<Subgrupo> listarTodos(){
		return new ArrayList<Subgrupo>(subGrupoRepo.findAll());
	}
	
	

}

