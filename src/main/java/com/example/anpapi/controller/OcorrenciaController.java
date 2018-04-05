package com.example.anpapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anpapi.model.Ocorrencia;
import com.example.anpapi.repository.OcorrenciaRepository;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {
	
	@Autowired
	private OcorrenciaRepository ocorrenciasRepo;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_OCORRENCIA')")
	public List<Ocorrencia> buscarTodasOcorrencias(){
		return new ArrayList<Ocorrencia>(ocorrenciasRepo.findAll());
	}

}
