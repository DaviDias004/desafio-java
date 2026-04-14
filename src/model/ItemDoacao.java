package model;

import java.time.LocalDate;

public class ItemDoacao {
    private int id;
    private String nome;
    private String categoria;
    private String descricao;
    private int quantidade;
    private String estadoConservacao;
    private LocalDate dataCadastro;
    private String status;

    public ItemDoacao(int id, String nome, String categoria, String descricao,
                      int quantidade, String estadoConservacao, String status) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.estadoConservacao = estadoConservacao;
        this.dataCadastro = LocalDate.now();
        this.status = status;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}