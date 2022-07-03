package com.avaliacao.steam.dto;

public class JogoDto {

    private String id;
    private String nome;
    private String estiloJogo;
    private Integer anoLancamento;
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
