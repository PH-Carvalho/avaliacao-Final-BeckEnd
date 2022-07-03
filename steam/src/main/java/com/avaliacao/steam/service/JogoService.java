package com.avaliacao.steam.service;

import java.util.List;

import com.avaliacao.steam.dto.JogoDto;

public interface JogoService {

    List<JogoDto> obterTodosJogos();
    JogoDto obterPorId(String id);
    List<JogoDto> obterPorEstiloJogo(String estiloJogo);
    JogoDto cadastarJogo(JogoDto jogo);
    void excluirJogo(String id);
    
}
