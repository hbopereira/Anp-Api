package com.example.anpapi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.anpapi.event.RecursoCriadoEvent;
import com.example.anpapi.model.Pessoa;
import com.example.anpapi.repository.PessoaRepository;
import com.example.anpapi.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private PessoaRepository pessoaRepo;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA')")
	public ResponseEntity<Pessoa> salvarPessoa(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response){
		Pessoa pessoaSalva = pessoaRepo.save(pessoa);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PESSOA')")
	public List<Pessoa> buscarTodosPessoas(){
		return new ArrayList<Pessoa>(pessoaService.buscarTodos());
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PESSOA')")
	public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable Long id){
		Pessoa pessoa = pessoaRepo.findOne(id);
		if(pessoa != null) {
		   return  ResponseEntity.status(HttpStatus.ACCEPTED).body(pessoa);
		}else {
		   return new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_PESSOA')")
	public void deletarPessoaPorId(@PathVariable Long id){
		//Pessoa pessoaSerDeletada = pessoaRepo.findOne(id);
		pessoaRepo.delete(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @Valid @RequestBody Pessoa pessoa){
		return ResponseEntity.ok(pessoaService.atualizar(id, pessoa));
	}
	
	@PutMapping("/{id}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeAtivoPessoa(@PathVariable Long id, @Valid @RequestBody Boolean ativo) {
		pessoaService.atualizarPropriedadeAtivo(id, ativo);
	}

}

