package com.cadastroprodutos.cadastroprodutos.controller.logincontroller.appcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cadastroprodutos.cadastroprodutos.entities.ProdutoEntity;
import com.cadastroprodutos.cadastroprodutos.services.ProdutoService;

@Controller
public class ListarProdutosController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/ListarProdutos")
    @ResponseBody
    public List<ProdutoEntity> listarProdutos() {
        return produtoService.obterTodosProdutos();  // Retorna a lista de produtos no formato JSON
    }
}
