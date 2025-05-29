package com.cadastroprodutos.cadastroprodutos.controller.logincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cadastroprodutos.cadastroprodutos.services.UsuarioService;

@Controller
@RequestMapping("/api")
public class CadastroUsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public String usuario(@RequestParam String usuario, @RequestParam String email, @RequestParam String password, RedirectAttributes redirectAttributes) {
        usuarioService.adicionarUsuario(usuario, email, password);

        // Usando RedirectAttributes para passar uma mensagem ou redirecionar para uma página após o cadastro
        redirectAttributes.addFlashAttribute("message", "Usuário cadastrado com sucesso!");
        return "redirect:/Login.html";  // Redireciona para uma página de sucesso (por exemplo)
    }
}
