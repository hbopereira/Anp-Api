package com.example.anpapi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anpapi.event.RecursoCriadoEvent;
import com.example.anpapi.model.Usuario;
import com.example.anpapi.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_USUARIO')")
	public ResponseEntity<Usuario> salvarUsuario(@Valid @RequestBody Usuario usuario, HttpServletResponse response){
		Usuario usuarioSalvo = usuarioRepo.save(usuario);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_USUARIO')")
	public List<Usuario> buscarTodosUsuarios(){
		return new ArrayList<Usuario>(usuarioRepo.findAll());
	}

}
