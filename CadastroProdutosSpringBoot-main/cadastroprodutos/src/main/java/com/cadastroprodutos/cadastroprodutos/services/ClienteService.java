package com.cadastroprodutos.cadastroprodutos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastroprodutos.cadastroprodutos.entities.ClienteEntity;
import com.cadastroprodutos.cadastroprodutos.repositorios.ClienteRepository;

@Service
public class ClienteService {
	
	
	@Autowired
	private ClienteRepository ClienteRepository;
	
	public String adicionarCliente(String nome, String email, String cpf) {
		if (nome != null && !nome.isEmpty() && email != null && !email.isEmpty() && cpf != null && !cpf.isEmpty()) {
			ClienteEntity cliente = new ClienteEntity(nome, cpf, email);
			ClienteRepository.save(cliente);
			return "Cliente adicionar com sucesso";
		} else {
			return "Dados inválidos para adicionar o cliente";
		}
	}

}
