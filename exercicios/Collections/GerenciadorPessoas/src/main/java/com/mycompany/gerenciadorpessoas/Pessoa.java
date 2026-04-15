package com.mycompany.gerenciadorpessoas;

public class Pessoa {

    private String nome, cidade;

    public Pessoa(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return String.format("Nome: %-10s | Cidade: %s", nome, cidade);
    }

}
