package com.example.anpapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anpapi.model.UnidadeMedida;
import com.example.anpapi.repository.UnidadeMedidaRepository;

@RestController
@RequestMapping("/unidades")
public class UnidadeMedidaController {
	
	@Autowired
	private UnidadeMedidaRepository unidadeMedidaRepo;
	
	@GetMapping
	public List<UnidadeMedida> buscarTodas(){
		return new ArrayList<UnidadeMedida>(unidadeMedidaRepo.findAll());
	}

}
