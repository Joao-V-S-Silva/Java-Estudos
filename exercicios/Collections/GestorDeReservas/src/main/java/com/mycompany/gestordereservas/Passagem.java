package com.mycompany.gestordereservas;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Classe principal que representa uma Passagem (reserva de voo).
 * Liga um Voo a um Passageiro com assento específico.
 * Gerencia ID único, status ativo/inativo e cancelação.
 * Ao criar, verifica disponibilidade e reserva assento automaticamente.
 */
public class Passagem {

    // ID único da reserva
    private int idReserva;
    // Set estático para garantir IDs únicos globalmente
    private static final Set<Integer> idExistentes = new HashSet<>();
    // Voo associado a esta passagem
    private Voo voo;
    // Passageiro dono da reserva
    private Passageiro passageiro;
    // Assento reservado (ex: "A1")
    private String assento;
    // Status da reserva (true = ativa)
    private boolean ativo;

    /**
     * Construtor para criar uma nova passagem/reserva.
     * @param voo O voo para reservar
     * @param passageiro O passageiro
     * @param assentoDesejado Assento desejado (ex "A1")
     * @throws IllegalArgumentException se assento não disponível
     */
    public Passagem(Voo voo, Passageiro passageiro, String assentoDesejado) {
        // Passo 1: Verifica se o assento está disponível no voo
        if (!voo.assentoDisponivel(assentoDesejado)) {
            throw new IllegalArgumentException("Erro, assento escolhido não está disponível");
        }
        // Passo 2: Associa voo e passageiro
        this.voo = voo;
        this.passageiro = passageiro;
        // Passo 3: Gera ID único
        this.idReserva = gerarId();
        // Passo 4: Define assento e ativa reserva
        this.assento = assentoDesejado;
        this.ativo = true;
        // Passo 5: Reserva o assento no voo (altera estado do voo)
        voo.reservarAssento(assento);
    }

    /**
     * Gera ID único para a reserva (mesma lógica das outras classes).
     * Loop até conseguir um não usado.
     */
    private int gerarId() {
        int id;
        do {
            id = ThreadLocalRandom.current().nextInt(1, 10000);
        } while (!idExistentes.add(id));
        return id;
    }

    /**
     * Cancela a reserva se o ID bater e estiver ativa.
     * Inverte o flag 'ativo' e retorna true se sucesso.
     * @param id ID da reserva a cancelar
     * @return true se cancelada, false caso contrário
     */
    public boolean cancelarReserva(int id) {
        // Verifica se é a mesma reserva e está ativa
        if (this.idReserva == id && this.isAtivo()) {
            ativo = !ativo;  // Inverte status para inativa
            return true;
        }
        return false;  // ID errado ou já inativa
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

    /**
     * Formata a passagem para exibição.
     * Mostra ID reserva, voo details, nome passageiro e assento.
     */
    @Override
    public String toString() {
        // Usa dados da passagem e voo/passageiro para string completa
        return String.format("Id da Reserva: %d, Id do Voo: %d, Partida: %s, Destino: %s, Passageiro: %s, Assento: %s", idReserva, voo.getId(), voo.getPartida(), voo.getDestino(), passageiro.getNome(), assento);
    }

}
