package com.cadastroprodutos.cadastroprodutos.controller.logincontroller.appcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cadastroprodutos.cadastroprodutos.services.ClienteService;

@Controller
public class AdicionarClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/addCliente")
	public String adicionarCliente(@RequestParam String nome, @RequestParam String email, @RequestParam String cpf) {
		clienteService.adicionarCliente(nome, email, cpf);
		return "redirect:/App.html";
	}

}
