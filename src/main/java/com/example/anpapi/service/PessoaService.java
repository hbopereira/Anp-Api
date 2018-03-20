package com.example.anpapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.anpapi.model.Pessoa;
import com.example.anpapi.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepo;
	
	public Pessoa salvar(Pessoa p) {
		return pessoaRepo.save(p);
	}
	
	public List<Pessoa> buscarTodos(){
		return new ArrayList<Pessoa>(pessoaRepo.findAll());
	}

	public Pessoa atualizar(Long id, Pessoa pessoa) {
		Pessoa pessoaSalva = buscarPessoaPorId(id);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "id");
		return pessoaRepo.save(pessoaSalva);
	}
	
	public Pessoa buscarPessoaPorId(Long id) {
		Pessoa pessoaSalva = pessoaRepo.findOne(id);
		if(pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaSalva;
	}

	public void atualizarPropriedadeAtivo(Long id, Boolean ativo) {
		Pessoa pessoaSalva = buscarPessoaPorId(id);
		pessoaSalva.setAtivo(ativo);
		pessoaRepo.save(pessoaSalva);
		
	}
	

}
