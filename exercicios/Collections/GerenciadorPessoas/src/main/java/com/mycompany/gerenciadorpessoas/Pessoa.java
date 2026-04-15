package com.mycompany.gerenciadorpessoas;

/**
 * Classe modelo que representa uma Pessoa no sistema de gerenciamento.
 * 
 * Esta classe armazena informações básicas de uma pessoa (nome e cidade)
 * e fornece métodos para acesso e modificação desses dados. É utilizada
 * para representar entidades individuais em listas e mapas de agrupamento
 * por cidade no GerenciadorPessoas.
 * 
 * @author Sistema GerenciadorPessoas
 */
public class Pessoa {

    /** Nome da pessoa (identificador principal). */
    private String nome;
    
    /** Cidade de residência da pessoa (usada para agrupamento). */
    private String cidade;

    /**
     * Construtor da classe Pessoa.
     * 
     * Inicializa uma nova instância com nome e cidade fornecidos.
     * Por que? Permite criar pessoas prontas para cadastro imediato
     * nas coleções (ArrayList e HashMap) do gerenciador.
     * 
     * @param nome o nome da pessoa
     * @param cidade a cidade de residência da pessoa
     */
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

    /**
     * Representação em string da pessoa para exibição.
     * 
     * Formato alinhado para listas e mapas ficarem organizados no console.
     * Por que ? Melhora legibilidade ao usar System.out.println(pessoa).
     * 
     * @return string formatada: "Nome: [nome] | Cidade: [cidade]"
     */
    @Override
    public String toString() {
        return String.format("Nome: %-10s | Cidade: %s", nome, cidade);
    }
}
