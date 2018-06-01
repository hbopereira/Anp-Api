package com.example.anpapi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.anpapi.event.RecursoCriadoEvent;
import com.example.anpapi.model.Grupo;
import com.example.anpapi.model.Subgrupo;
import com.example.anpapi.repository.SubgrupoRepository;

@RestController
@RequestMapping("/subgrupos")
public class SubgrupoController {
	
	@Autowired
	private SubgrupoRepository subGrupoRepo;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	public ResponseEntity<Subgrupo> salvarGrupo(@Valid @RequestBody Subgrupo subgrupo, HttpServletResponse response) {
		Subgrupo subgrupoSalvo = subGrupoRepo.save(subgrupo);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, subgrupoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(subgrupoSalvo);
	}
	
	@GetMapping
	public List<Subgrupo> listarTodos(){
		return new ArrayList<Subgrupo>(subGrupoRepo.findAll());
	}
	
	

}

