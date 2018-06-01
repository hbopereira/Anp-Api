package com.example.anpapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anpapi.model.Classe;
import com.example.anpapi.repository.ClasseRepository;

@RestController
@RequestMapping("/classes")
public class ClasseController {
	
	@Autowired
	private ClasseRepository classeRepo;
	
	@GetMapping
	public List<Classe> listarTodas(){
		return new ArrayList<Classe>(classeRepo.findAll());
	}

}
