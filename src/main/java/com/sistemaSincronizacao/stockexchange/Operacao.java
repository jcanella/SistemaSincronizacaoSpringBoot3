package com.sistemaSincronizacao.stockexchange;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Operacao {
    private String acao;
    private int quantidade;
    private double valor;

    private LocalTime data;

    // Construtor
    public Operacao(String acao, int quantidade, double valor, LocalTime data) {
        this.acao = acao;
        this.quantidade = quantidade;
        this.valor = valor;
        this.data = data;
    }

    public LocalTime getData() {
        return data;
    }

    public void setData(LocalTime data) {
        this.data = data;
    }

    // Getters e setters
    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
