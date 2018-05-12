package com.example.anpapi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.example.anpapi.model.Produto;
import com.example.anpapi.repository.ProdutoRepository;
import com.example.anpapi.repository.filter.ProdutoFilter;
import com.example.anpapi.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository prodRepo;
	
	@Autowired
	private ProdutoService prodService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	public ResponseEntity<Produto> salvarProduto(@Valid @RequestBody Produto produto, HttpServletResponse response){
		Produto produtoSalvo = prodService.salvar(produto);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, produtoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
	}
	
	@GetMapping
	public Page<Produto> buscarTodosProdutos(ProdutoFilter produtoFilter, Pageable pageable){
		return prodRepo.filtrar(produtoFilter, pageable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id){
		Produto produto = prodRepo.findOne(id);
		if(produto != null) {
		   return  ResponseEntity.status(HttpStatus.ACCEPTED).body(produto);
		}else {
		   return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @Valid @RequestBody Produto produto) {
	  return ResponseEntity.ok(prodService.atualizar(id, produto));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarProdutoPorId(@PathVariable Long id) {
		prodRepo.delete(id);
	}

}
