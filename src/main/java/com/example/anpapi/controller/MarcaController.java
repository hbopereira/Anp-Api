package com.example.anpapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anpapi.model.Marca;
import com.example.anpapi.repository.MarcaRepository;

@RestController
@RequestMapping("/marcas")
public class MarcaController {
	
	@Autowired
	private MarcaRepository marcaRepo;
	
	@GetMapping
	public List<Marca> listarTodas(){
		return new ArrayList<Marca>(marcaRepo.findAll());
	}

}
