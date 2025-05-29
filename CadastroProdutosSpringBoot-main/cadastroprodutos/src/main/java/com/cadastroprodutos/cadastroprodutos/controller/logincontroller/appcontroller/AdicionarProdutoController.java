package com.cadastroprodutos.cadastroprodutos.controller.logincontroller.appcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cadastroprodutos.cadastroprodutos.services.ProdutoService;

@Controller
public class AdicionarProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/addProduto")
    public String adicionarProduto(@RequestParam String nome, @RequestParam String categoria, @RequestParam double preco) {
        produtoService.adicionarProduto(nome, categoria, preco);
        return "redirect:/App.html";
    }
}

