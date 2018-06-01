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
import org.springframework.web.bind.annotation.RestController;

import com.example.anpapi.event.RecursoCriadoEvent;
import com.example.anpapi.model.Grupo;
import com.example.anpapi.model.Marca;
import com.example.anpapi.repository.MarcaRepository;

@RestController
@RequestMapping("/marcas")
public class MarcaController {
	
	@Autowired
	private MarcaRepository marcaRepo;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	public ResponseEntity<Marca> salvarGrupo(@Valid @RequestBody Marca marca, HttpServletResponse response) {
		Marca marcaSalva = marcaRepo.save(marca);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, marcaSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(marcaSalva);
	}
	
	@GetMapping
	public List<Marca> listarTodas(){
		return new ArrayList<Marca>(marcaRepo.findAll());
	}

}
