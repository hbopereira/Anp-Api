package com.example.anpapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.anpapi.model.Classe;
import com.example.anpapi.repository.ClasseRepository;

@Service
public class ClasseService {
	
	private ClasseRepository classeRepo;
	
	public Classe atualizar(Long id, Classe classe) {
		Classe classeSalva = buscarClassePorId(id);
		BeanUtils.copyProperties(classe, classeSalva, "id");
		return classeRepo.save(classeSalva);
	}
	
	public Classe buscarClassePorId(Long id) {
		Classe classeSalva = classeRepo.findOne(id);
		if(classeSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return classeSalva;
	}

}
