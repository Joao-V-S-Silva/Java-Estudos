package com.mycompany.gestordereservas;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Passagem {

    private int idReserva;
    private static final Set<Integer> idExistentes = new HashSet<>();
    private Voo voo;
    private Passageiro passageiro;
    private String assento;
    private boolean ativo;

    public Passagem(Voo voo, Passageiro passageiro, String assentoDesejado) {
        if (!voo.assentoDisponivel(assentoDesejado)) {
            throw new IllegalArgumentException("Erro, assento escolhido não está disponível");
        }
        this.voo = voo;
        this.passageiro = passageiro;
        this.idReserva = gerarId();
        this.assento = assentoDesejado;
        this.ativo = true;

        voo.reservarAssento(assento);
    }

    private int gerarId() {
        int id;
        do {
            id = ThreadLocalRandom.current().nextInt(1, 10000);
        } while (!idExistentes.add(id));
        return id;
    }

    public boolean cancelarReserva(int id) {
        if (this.idReserva == id && this.isAtivo()) {
            ativo = !ativo;
            return true;
        }
        return false;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return String.format("Id da Reserva: %d, Id do Voo: %d, Partida:  %s, Destino: %s, Passageiro: %s, Assento: %s", idReserva, voo.getId(), voo.getPartida(), voo.getDestino(), passageiro.getNome(), assento);
    }

}
