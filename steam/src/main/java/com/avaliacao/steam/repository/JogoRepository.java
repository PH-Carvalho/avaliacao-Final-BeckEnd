package com.avaliacao.steam.repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.avaliacao.steam.model.Jogo;

public interface JogoRepository extends MongoRepository<Jogo,String> {

   List<Jogo> findByEstiloJogo(String estiloJogo);  
}
