package com.mycompany.sistemadevotacao;

// Classe Candidato estende Pessoa (herança), ou seja, herda nome e idade
public class Candidato extends Pessoa {

    // Número do candidato (identificador único)
    private int numero;

    // Total de votos recebidos
    private int totalVotos;

    // Construtor do candidato, recebe nome, idade e número
    public Candidato(String nome, int idade, int numero) {
        super(nome, idade); // Chama o construtor da classe Pessoa
        if (idade < 18) {
            // Validação extra para garantir que apenas maiores de idade sejam candidatos
            throw new IllegalArgumentException("Para se candidatar, precisa ter ao menos 18 anos");
        }
        this.numero = numero;
        this.totalVotos = 0; // Inicializa com zero votos
    }

    // Método para alterar a idade com validação
    public void setIdade(int idade) {
        if (idade < 18) {
            throw new IllegalArgumentException("Candidato deve ter pelo menos 18 anos.");
        }
        this.idade = idade;
    }

    // Método que incrementa o número de votos recebidos
    public void receberVoto() {
        this.totalVotos++;
    }

    // Getters e setters padrão
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(int totalVotos) {
        this.totalVotos = totalVotos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // hashCode sobrescrito com base no número do candidato
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.numero; // Multiplica para evitar colisões
        return hash;
    }

    // equals sobrescrito para comparar candidatos pelo número
    @Override
    public boolean equals(Object obj) {
        // Verifica se são o mesmo objeto
        if (this == obj) {
            return true;
        }
        // Verifica se o outro objeto é nulo ou de classe diferente
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // Faz o cast e compara pelo número
        final Candidato other = (Candidato) obj;
        return this.numero == other.numero;
    }

    // toString personalizado para imprimir informações do candidato de forma legível
    @Override
    public String toString() {
        return String.format("%s Candidato {numero: %d, totalVotos: %d}",
                super.toString(), numero, totalVotos);
    }
}
