package com.example.anpapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.anpapi.model.Cidade;
import com.example.anpapi.repository.CidadeRepository;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
	
	@Autowired
	private CidadeRepository cidadeRepo;
	
	@GetMapping
	public List<Cidade> pesquisar(@RequestParam Long estado){
		return cidadeRepo.findByEstadoId(estado);
	}

}
