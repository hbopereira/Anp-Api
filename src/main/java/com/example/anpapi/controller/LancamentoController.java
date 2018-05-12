package com.example.anpapi.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.anpapi.dto.LancamentoEstatisticaCategoria;
import com.example.anpapi.dto.LancamentoEstatisticaDia;
import com.example.anpapi.dto.LancamentoEstatisticaOcorrencia;
import com.example.anpapi.event.RecursoCriadoEvent;
import com.example.anpapi.exceptionhandler.AnpExceptionHandler.Erro;
import com.example.anpapi.model.Lancamento;
import com.example.anpapi.repository.LancamentoRepository;
import com.example.anpapi.repository.filter.LancamentoFilter;
import com.example.anpapi.repository.projection.ResumoLancamento;
import com.example.anpapi.service.LancamentoService;
import com.example.anpapi.service.exception.PessoaInexistenteOuInativoException;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {
	
	@Autowired
	private LancamentoService lancamentoService;
	
	@Autowired
	private LancamentoRepository lancamentoRepo;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private MessageSource messageSource;
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_LANCAMENTO')")
	public ResponseEntity<Lancamento> salvarLancamento(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response){
		Lancamento lancamentoSalvo = lancamentoService.salvar(lancamento);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
	}
	
	@GetMapping("/estatisticas/por-categoria")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO')")
	public List<LancamentoEstatisticaCategoria> porCategoria(){
		return this.lancamentoRepo.porCategoria(LocalDate.now());
	}
	
	@GetMapping("/estatisticas/por-ocorrencia")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO')")
	public List<LancamentoEstatisticaOcorrencia> porOcorrencia(){
		return this.lancamentoRepo.porOcorrencia(LocalDate.now());
	}
	
	
	@GetMapping("/estatisticas/por-dia")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO')")
	public List<LancamentoEstatisticaDia> porDia() {
		return this.lancamentoRepo.porDia(LocalDate.now());
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO')")
	public Page<Lancamento> buscarTodosLancamentos(LancamentoFilter lancamentoFilter, Pageable pageable){
		return lancamentoRepo.filtrar(lancamentoFilter, pageable);
	}
	
	@GetMapping(params = "resumo")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO')")
	public Page<ResumoLancamento> buscarTodosLancamentosResumidos(LancamentoFilter lancamentoFilter, Pageable pageable){
		return lancamentoRepo.resumoLancamento(lancamentoFilter, pageable);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO')")
	public ResponseEntity<Lancamento> buscarLancamentoPorId(@PathVariable Long id){
		Lancamento lancamento = lancamentoRepo.findOne(id);
		if(lancamento != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(lancamento);
		}else {
			return new ResponseEntity<Lancamento>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_LANCAMENTO')")
	public void deletarLancamento(@PathVariable Long id) {
		lancamentoRepo.delete(id);
		
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Lancamento> atualizarLancamento(@PathVariable Long id, @RequestBody @Valid Lancamento lancamento){
		Lancamento lancamentoSalvo = lancamentoService.atualizar(id, lancamento);
		return ResponseEntity.ok(lancamentoSalvo);
	
	}
	
	@ExceptionHandler({ PessoaInexistenteOuInativoException.class })
	public ResponseEntity<Object> handlePessoaInexistenteOuInativoException(PessoaInexistenteOuInativoException ex){
		String mensagemUsuário = messageSource.getMessage("pessoa.inexistente-ou-inativa", null, LocaleContextHolder.getLocale());
	    String mensagemDesenvolvedor = ex.toString();
	    List<Erro> erros = Arrays.asList(new Erro(mensagemUsuário, mensagemDesenvolvedor));
	    
	    return ResponseEntity.badRequest().body(erros);
	}

}
