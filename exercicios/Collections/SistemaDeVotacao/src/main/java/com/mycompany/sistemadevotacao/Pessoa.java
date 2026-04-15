package com.mycompany.sistemadevotacao;

// Classe abstrata Pessoa — serve como base para outras classes, como Candidato
public abstract class Pessoa {

    // Atributos protegidos: podem ser acessados por subclasses (como Candidato)
    protected String nome;
    protected int idade;

    // Construtor: recebe nome e idade como parâmetros
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Método toString sobrescrito para retornar uma representação textual do objeto
    @Override
    public String toString() {
        // Exibe os dados básicos da pessoa
        return String.format("Pessoa: nome: '%s', idade: %d}", nome, idade);
    }
}
