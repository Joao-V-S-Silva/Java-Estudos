package com.mycompany.gestordereservas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Voo {

    private String partida, destino;
    private int capacidade, id;
    private List<String> assentosReservados = new ArrayList<>();
    private List<Passagem> passagens = new ArrayList<>();
    private List<String> assentos = new ArrayList<>();
    private static final Set<Integer> idExistentes = new HashSet<>();

    public Voo(String partida, String destino, int capacidade) {
        this.partida = partida;
        this.destino = destino;
        this.capacidade = capacidade;
        this.id = gerarId();
        for (int i = 0; i < capacidade; i++) {
            assentos.add("A" + (i + 1));
        }
    }

    private int gerarId() {
        int id;
        do {
            id = ThreadLocalRandom.current().nextInt(1, 1000);
        } while (!idExistentes.add(id));
        return id;
    }

    public boolean assentoDisponivel(String assento) {
        return assentos.contains(assento);
    }

    public boolean reservarAssento(String assento) {
        if (!assentosReservados.contains(assento)) {
            for (int i = 0; i < assentos.size(); i++) {
                if (assentos.get(i).equals(assento)) {
                    assentosReservados.add(assentos.get(i));
                    return true;
                }
            }
        } else {
            System.out.println("Erro, o assento desejado já foi reservado !");
        }
        return false;
    }

    public void listarReservas(String destino) {
        if (!passagens.isEmpty()) {
            
        } else {
        }
    }

    public List<String> mostrarAssentos() {
        return this.getAssentos();
    }

    public List<String> getReservas() {
        return assentosReservados;
    }

    public void setReservas(List<String> reservas) {
        this.assentosReservados = reservas;
    }

    public List<String> getAssentos() {
        return assentos;
    }

    public void setAssentos(List<String> assento) {
        this.assentos = assento;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getId() {
        return id;
    }

    public List<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(List<Passagem> passagens) {
        this.passagens = passagens;
    }

    @Override
    public String toString() {
        return String.format("Id do Voo: %d, Partida: %s, Destino: %s, Capacidade do voo: %d, Reservas do voo: %s", id, partida, destino, capacidade, assentosReservados);
    }

}
