package com.example.anpapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anpapi.model.Grupo;
import com.example.anpapi.repository.GrupoRepository;

@RestController
@RequestMapping("/grupos")
public class GrupoController {
	
	@Autowired
	private GrupoRepository grupoRepo;
	
	@GetMapping
	public List<Grupo> listarTodos(){
		return new ArrayList<Grupo>(grupoRepo.findAll());
	}
	
	

}
