package com.mycompany.agrupamentodepessoas;

public class Pessoa {

    // Atributo: armazena o nome da pessoa
    private String nome;
    
    // Atributo: armazena a idade da pessoa
    private int idade;

    // Construtor: inicializa os atributos nome e idade quando um objeto Pessoa é criado
    public Pessoa(String nome, int idade) {
        this.nome = nome;      // Atribui o nome passado como parâmetro
        this.idade = idade;    // Atribui a idade passada como parâmetro
    }

    // Getter do nome: retorna o valor do atributo nome
    public String getNome() {
        return nome;
    }

    // Setter do nome: permite modificar o valor do atributo nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter da idade: retorna o valor do atributo idade
    public int getIdade() {
        return idade;
    }

    // Setter da idade: permite modificar o valor do atributo idade
    public void setIdade(int idade) {
        this.idade = idade;
    }

}
