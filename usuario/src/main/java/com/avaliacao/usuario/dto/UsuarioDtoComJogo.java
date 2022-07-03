package com.avaliacao.usuario.dto;


import com.avaliacao.usuario.client.JogoClient;

public class UsuarioDtoComJogo extends UsuarioDto {

    private JogoClient jogoComDetalhes;

    public JogoClient getJogoComDetalhes() {
        return jogoComDetalhes;
    }

    public void setJogoComDetalhes(JogoClient jogoComDetalhes) {
        this.jogoComDetalhes = jogoComDetalhes;
    }  
    
}
