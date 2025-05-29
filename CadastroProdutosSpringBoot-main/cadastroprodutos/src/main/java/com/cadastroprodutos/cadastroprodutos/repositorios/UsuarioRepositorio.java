package com.cadastroprodutos.cadastroprodutos.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cadastroprodutos.cadastroprodutos.entities.UsuarioEntity;

@Repository
public interface UsuarioRepositorio extends CrudRepository<UsuarioEntity, Integer> {

    Optional<UsuarioEntity> findByUsuario(String Usuario); 

}
