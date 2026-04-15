package com.mycompany.gestordereservas;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Classe Passageiro que herda de Pessoa.
 * Adiciona um ID único para cada passageiro (gerado aleatoriamente e garantido único).
 * Usa um Set estático para rastrear IDs já usados em toda a aplicação.
 */
public class Passageiro extends Pessoa {

    // ID único e imutável para este passageiro
    private final int id;
    // Conjunto estático que guarda todos IDs já gerados (singleton-like para unicidade)
    private static final Set<Integer> idExistentes = new HashSet<>();

    /**
     * Construtor do Passageiro.
     * Chama super para Pessoa e gera ID único automaticamente.
     */
    public Passageiro(String nome, String sexo, int idade) {
        super(nome, sexo, idade);  // Inicializa atributos da Pessoa
        this.id = gerarId();       // Gera e atribui ID único
    }

    /**
     * Gera um ID único aleatório entre 1 e 9999.
     * Usa loop do-while até conseguir adicionar ao Set (garante unicidade).
     * ThreadLocalRandom é thread-safe para geração randômica.
     */
    private int gerarId() {
        int id;
        do {
            // Gera número randômico
            id = ThreadLocalRandom.current().nextInt(1, 10000);
        } while (!idExistentes.add(id));  // Repete se já existia (add retorna false)
        return id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Id do passageiro: %d", id);
    }
}
