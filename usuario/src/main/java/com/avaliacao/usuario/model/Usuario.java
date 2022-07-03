package com.avaliacao.usuario.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("usuario")
public class Usuario {
    
    @Id
  private String id;
   @NotBlank(message = "Nome não pode está vazio")
   @NotEmpty(message = "Nome deve ser adiconado!")
  private String nome;
  @NotBlank(message = "NickName não pode está vazio")
  @NotEmpty(message = "NickName deve ser adiconado!")
  private  String nickName;
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
    public void setJogoId(String jogoId) {
        this.jogoId = jogoId;
    }
 
    
}
