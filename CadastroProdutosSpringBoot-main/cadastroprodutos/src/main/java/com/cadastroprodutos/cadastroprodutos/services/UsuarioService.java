package com.cadastroprodutos.cadastroprodutos.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastroprodutos.cadastroprodutos.entities.UsuarioEntity;
import com.cadastroprodutos.cadastroprodutos.repositorios.UsuarioRepositorio;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    // Método para adicionar um usuário
    public void adicionarUsuario(String usuario, String email, String password) {
        if (usuario != null && !usuario.isEmpty() && email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
            String senhaCriptografada = BCrypt.hashpw(password, BCrypt.gensalt());
            
            UsuarioEntity criarUsuario = new UsuarioEntity(usuario, email, senhaCriptografada);
            usuarioRepositorio.save(criarUsuario);
        } else {
            System.out.println("Erro ao adicionar usuario: Dados inválidos.");
        }
    }
    
    // Método para validar o login do usuário
    public boolean validarUsuario(String usuario, String senha) {
        Optional<UsuarioEntity> usuarioOptional = usuarioRepositorio.findByUsuario(usuario);

        if (usuarioOptional.isPresent()){
            UsuarioEntity usuarioEntity = usuarioOptional.get();
            
            return BCrypt.checkpw(senha, usuarioEntity.getPassword());
        } else {
            System.out.println("Usuário não encontrado.");
            return false;
        }
    }
}
