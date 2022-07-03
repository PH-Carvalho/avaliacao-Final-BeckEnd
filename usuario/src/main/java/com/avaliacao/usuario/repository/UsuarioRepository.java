package com.avaliacao.usuario.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.avaliacao.usuario.model.Usuario;

public interface UsuarioRepository  extends MongoRepository<Usuario,String>{
    
}
