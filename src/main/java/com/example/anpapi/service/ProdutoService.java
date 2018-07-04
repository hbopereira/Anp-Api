package com.example.anpapi.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.anpapi.model.Pessoa;
import com.example.anpapi.model.Produto;
import com.example.anpapi.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
	@Autowired
	private ProdutoRepository prodRepo;
	
	/*public Produto salvar(Produto produto) {
		produto.getFornecedores().forEach(c -> c.setProduto(produto));
		return prodRepo.save(produto);
	} */
	
	public Produto salvar(Produto produto) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataCadastro = Calendar.getInstance().getTime();
		String dataFormatada = sdf.format(dataCadastro);
		produto.setDataCadastro(dataFormatada);
		
		return prodRepo.save(produto);
	}
	
	public Produto atualizar(Long id, Produto produto) {
		Produto produtoSalvo = buscarProdutoPorId(id);
		BeanUtils.copyProperties(produto, produtoSalvo, "id");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataModificacao = Calendar.getInstance().getTime();
		String dataFormatada = sdf.format(dataModificacao);
		produtoSalvo.setDataModificacao(dataFormatada);
		
		return prodRepo.save(produtoSalvo);
	}
	
	/*public Produto atualizar(Long id, Produto produto) {
		Produto produtoSalvo = buscarProdutoPorId(id);
		
		produtoSalvo.getFornecedores().clear();
		produtoSalvo.getFornecedores().addAll(produto.getFornecedores());
		produtoSalvo.getFornecedores().forEach(c -> c.setProduto(produtoSalvo));
		
		BeanUtils.copyProperties(produto, produtoSalvo, "id", "fornecedores");
		return prodRepo.save(produtoSalvo);
	}*/
	
	public Produto buscarProdutoPorId(Long id) {
		Produto produtoSalvo = prodRepo.findOne(id);
		if(produtoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return produtoSalvo;
	}
	
	public void obterCodigoBarrasAleatorio() {	
		Random r = new Random();
		r.nextInt();
	}
}
