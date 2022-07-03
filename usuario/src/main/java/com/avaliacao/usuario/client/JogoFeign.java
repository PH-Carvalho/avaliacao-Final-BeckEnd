package com.avaliacao.usuario.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("steam-ms")
public interface JogoFeign {
    
    @RequestMapping(method = RequestMethod.GET,value="/steam/jogo/{id}")

    JogoClient obterJogoPorId(@PathVariable String id);
}
