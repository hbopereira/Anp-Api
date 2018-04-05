package com.example.anpapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.anpapi.model.Lancamento;
import com.example.anpapi.model.Pessoa;
import com.example.anpapi.repository.LancamentoRepository;
import com.example.anpapi.repository.PessoaRepository;
import com.example.anpapi.service.exception.PessoaInexistenteOuInativoException;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentoRepo;
	
	@Autowired
	private PessoaRepository pessoaRepo;
	
	
	public Lancamento salvar(Lancamento lancamento) {
		Pessoa pessoa = pessoaRepo.findOne(lancamento.getPessoa().getId());
		if(pessoa == null || pessoa.isInativo()) {
			throw new PessoaInexistenteOuInativoException();
		}
		return lancamentoRepo.save(lancamento);
	}
	
	public List<Lancamento> buscarTodos(){
		return new ArrayList<Lancamento>(lancamentoRepo.findAll());
	}
	
	public Lancamento atualizar(Long id, Lancamento lancamento) {
		Lancamento lancamentoSalvo = buscarLancamentoExistente(id);
		if (!lancamento.getPessoa().equals(lancamentoSalvo.getPessoa())) {
			validarPessoa(lancamento);
		}

		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "id");

		return lancamentoRepo.save(lancamentoSalvo);
	}

	private void validarPessoa(Lancamento lancamento) {
		Pessoa pessoa = null;
		if (lancamento.getPessoa().getId() != null) {
			pessoa = pessoaRepo.findOne(lancamento.getPessoa().getId());
		}

		if (pessoa == null || pessoa.isInativo()) {
			throw new PessoaInexistenteOuInativoException();
		}
	}

	private Lancamento buscarLancamentoExistente(Long id) {
		Lancamento lancamentoSalvo = lancamentoRepo.findOne(id);
		if (lancamentoSalvo == null) {
			throw new IllegalArgumentException();
		}
		return lancamentoSalvo;
	}
	
	private Lancamento buscarLancamentoPorId(Long id) {
		Lancamento lancamentoSalvo = lancamentoRepo.findOne(id);
		if(lancamentoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return lancamentoSalvo;
	}

}
