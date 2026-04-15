package com.mycompany.gestordereservas;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Passageiro extends Pessoa {

    private final int id;
    private static final Set<Integer> idExistentes = new HashSet<>();

    public Passageiro(String nome, String sexo, int idade) {
        super(nome, sexo, idade);
        this.id = gerarId();
    }

    private int gerarId() {
        int id;
        do {
            id = ThreadLocalRandom.current().nextInt(1, 10000);
        } while (!idExistentes.add(id));
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
