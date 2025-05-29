package com.cadastroprodutos.cadastroprodutos.repositorios;

import org.springframework.stereotype.Repository;

import com.cadastroprodutos.cadastroprodutos.entities.ProdutoEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProdutoRepositorio extends JpaRepository<ProdutoEntity, Integer> {

}
