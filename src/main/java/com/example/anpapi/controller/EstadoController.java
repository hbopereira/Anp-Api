package com.example.anpapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anpapi.model.Estado;
import com.example.anpapi.repository.EstadoRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepo;
	
	@GetMapping
	public List<Estado> listarTodos(){
		return new ArrayList<Estado>(estadoRepo.findAll());
	}

}
