package com.avaliacao.steam.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.steam.dto.JogoDto;
import com.avaliacao.steam.service.JogoService;

@RestController
@RequestMapping("/steam/jogo")

public class JogoController {

    @Autowired
    private JogoService service;

    @PostMapping

    public ResponseEntity<JogoDto> adicionarJogo (@RequestBody @Valid JogoDto jogo){

        return new ResponseEntity<>(service.cadastarJogo(jogo),HttpStatus.CREATED);    
    }

    @GetMapping
    public List<JogoDto> obterOsTodosJogos(){

       return service.obterTodosJogos();
    }

    @GetMapping("/{id}")

   public JogoDto obterJogoPorId(@PathVariable String id){

        return service.obterPorId(id);
    }

    @GetMapping("/estilo/{estiloJogo}")
    
    public List<JogoDto>obterJogoPorEstilo(@PathVariable String estiloJogo){

        return service.obterPorEstiloJogo(estiloJogo);
    }

    @DeleteMapping("/{id}")
    public void excluirJogo(@PathVariable String id){

        service.excluirJogo(id);
    }
   
}
