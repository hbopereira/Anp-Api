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
import com.example.anpapi.model.Grupo;
import com.example.anpapi.repository.GrupoRepository;

@RestController
@RequestMapping("/grupos")
public class GrupoController {
	
	@Autowired
	private GrupoRepository grupoRepo;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	public ResponseEntity<Grupo> salvarGrupo(@Valid @RequestBody Grupo grupo, HttpServletResponse response) {
		Grupo grupoSalvo = grupoRepo.save(grupo);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, grupoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(grupoSalvo);
	}
	
	@GetMapping
	public List<Grupo> listarTodos(){
		return new ArrayList<Grupo>(grupoRepo.findAll());
	}
	
	

}
