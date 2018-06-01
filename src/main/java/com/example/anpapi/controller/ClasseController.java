package com.example.anpapi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anpapi.event.RecursoCriadoEvent;
import com.example.anpapi.model.Categoria;
import com.example.anpapi.model.Classe;
import com.example.anpapi.repository.ClasseRepository;

@RestController
@RequestMapping("/classes")
public class ClasseController {
	
	@Autowired
	private ClasseRepository classeRepo;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	public ResponseEntity<Classe> salvarClasse(@Valid @RequestBody Classe classe, HttpServletResponse response) {
		Classe classeSalva = classeRepo.save(classe);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, classeSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(classeSalva);
	}
	
	@GetMapping
	public List<Classe> listarTodas(){
		return new ArrayList<Classe>(classeRepo.findAll());
	}

}
