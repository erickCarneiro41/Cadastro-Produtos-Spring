package com.cadastroprodutos.cadastroprodutos.controller.logincontroller.appcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cadastroprodutos.cadastroprodutos.services.ProdutoService;

@Controller
public class ModificarProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/ModificarProduto")
    public ResponseEntity<String> modificarProduto(@RequestParam("id") Integer id,
                                                  @RequestParam("nome") String nome,
                                                  @RequestParam("preco") Double preco) {
        try {
            produtoService.modificarProduto(id, nome, preco);
            return ResponseEntity.ok("Produto modificado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao modificar produto: " + e.getMessage());
        }
    }
}
