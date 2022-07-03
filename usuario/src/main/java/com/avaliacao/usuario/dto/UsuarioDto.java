package com.avaliacao.usuario.dto;

public class UsuarioDto {
   private String id;
   private String nome;
   private String nickName;
   private String jogoId;
    
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getJogoId() {
        return jogoId;
    }
    public void setJogoId(String JogoId) {
        this.jogoId =JogoId;
    }

    
}
