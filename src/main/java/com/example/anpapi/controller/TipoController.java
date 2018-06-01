package com.example.anpapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anpapi.model.Tipo;
import com.example.anpapi.repository.TipoRepository;

@RestController
@RequestMapping("/tipos")
public class TipoController {
	
	@Autowired
	private TipoRepository tipoRepo;
	
	@GetMapping
	public List<Tipo> buscarTodos(){
		return new ArrayList<Tipo>(tipoRepo.findAll());
	}

}
