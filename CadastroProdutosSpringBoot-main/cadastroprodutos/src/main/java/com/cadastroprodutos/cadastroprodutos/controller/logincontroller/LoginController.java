package com.cadastroprodutos.cadastroprodutos.controller.logincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cadastroprodutos.cadastroprodutos.services.UsuarioService;

@RestController
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("usuario") String usuario, @RequestParam("password") String password) {
        if (usuarioService.validarUsuario(usuario, password)) {
            return ResponseEntity.ok("redirect:/App.html"); 
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas"); 
        }
    }
}
