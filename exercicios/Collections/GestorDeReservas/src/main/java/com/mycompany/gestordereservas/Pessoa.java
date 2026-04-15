package com.mycompany.gestordereservas;

/**
 * Classe abstrata base para representar qualquer pessoa no sistema.
 * Define os atributos básicos que toda pessoa tem: nome, sexo e idade.
 * Serve como pai para classes mais específicas como Passageiro.
 */
public abstract class Pessoa {
    // Atributos protegidos para serem acessados por subclasses
    protected String nome, sexo;  // Nome e sexo da pessoa
    protected int idade;          // Idade em anos

    /**
     * Construtor da classe Pessoa.
     * @param nome Nome completo da pessoa
     * @param sexo Sexo ('M' ou 'F')
     * @param idade Idade da pessoa em anos
     */
    public Pessoa(String nome, String sexo, int idade) {
        // Inicializa os atributos com os valores recebidos
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        // Simples assim - nada mais!
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Sobrescreve toString para uma representação legível da pessoa.
     * Útil para imprimir informações básicas.
     */
    @Override
    public String toString() {
        // Formata como string com nome, sexo e idade
        return String.format("Nome: %s, Sexo: %s, Idade: %d, ", nome, sexo, idade);
    }
}
