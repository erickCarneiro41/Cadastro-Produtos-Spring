package com.cadastroprodutos.cadastroprodutos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastroprodutos.cadastroprodutos.entities.ProdutoEntity;
import com.cadastroprodutos.cadastroprodutos.repositorios.ProdutoRepositorio;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio; 
	
	// Método responsável pela adição do produto no DB
	public String adicionarProduto(String nome, String categoria, double preco) {
	    if (nome != null && !nome.isEmpty() && categoria != null && !categoria.isEmpty() && preco > 0) {
	        ProdutoEntity novoProduto = new ProdutoEntity(nome, categoria, preco);
	        produtoRepositorio.save(novoProduto);
	        return "Produto adicionado com sucesso!";
	    } else {
	        return "Dados inválidos para adicionar o produto.";
	    }
	}
    
    public void modificarProduto(Integer id, String nome, double preco) {
        ProdutoEntity produto = produtoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setNome(nome);
        produto.setPreco(preco);

        produtoRepositorio.save(produto);
    }
  
    // Método resposável pela alteração dos produtos no DB
    public void updateProduto(ProdutoEntity produto) {
        ProdutoEntity produtoExistente = produtoRepositorio.findById(produto.getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produtoExistente.setNome(produto.getNome());
        produtoExistente.setPreco(produto.getPreco());

        produtoRepositorio.save(produtoExistente);
    }
    
	// Método responsável por retornar os produtos
    public List<ProdutoEntity> obterTodosProdutos() {
        return produtoRepositorio.findAll(); 
    }	


}

