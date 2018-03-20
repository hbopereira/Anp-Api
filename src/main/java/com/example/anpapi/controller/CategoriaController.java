package com.example.anpapi.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anpapi.event.RecursoCriadoEvent;
import com.example.anpapi.model.Categoria;
import com.example.anpapi.repository.CategoriaRepository;
import com.example.anpapi.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService catService;
	
	@Autowired
	private CategoriaRepository catRepo;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA')")
	public ResponseEntity<Categoria> salvarCategoria(@Valid @RequestBody Categoria cat, HttpServletResponse response) {
		Categoria categoriaSalva = catRepo.save(cat);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA')")
	public Set<Categoria> buscarTodasCategorias(){
		return new HashSet<Categoria>(catService.buscarTodos());
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA')")
	public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable Long id) {
		Categoria categoria = catRepo.findOne(id);
		if(categoria != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoria);
		}
		else {
		    return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);  
		}
	}


}
