package com.avaliacao.steam.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("jogo")
public class Jogo {
    @Id
    private String id;
    @NotEmpty (message = "O Nome do jogo deve ser informado!")
    private String nome;
    private String estiloJogo;
    private Integer anoLancamento;
    @Positive (message = "O valor do produto deve ser acima de zero!")
    private Integer preco;

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
    public String getEstiloJogo() {
        return estiloJogo;
    }
    public void setEstiloJogo(String estiloJogo) {
        this.estiloJogo = estiloJogo;
    }
    public Integer getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public Integer getPreco() {
        return preco;
    }
    public void setPreco(Integer preco) {
        this.preco = preco;
    }

}

