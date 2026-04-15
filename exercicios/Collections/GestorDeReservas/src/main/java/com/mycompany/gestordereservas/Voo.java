package com.mycompany.gestordereservas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Classe Voo - coração do sistema de reservas.
 * Gerencia rota (partida/destino), capacidade, geração de assentos (A1, A2...), reservas de assentos e lista de passagens.
 * Usa listas separadas para assentos disponíveis/reservados e passagens.
 */
public class Voo {

    // Cidade de origem e destino do voo
    private String partida, destino;
    // Capacidade total de assentos e ID único do voo
    private int capacidade, id;
    // Lista de assentos já reservados
    private List<String> assentosReservados = new ArrayList<>();
    // Lista de passagens deste voo
    private List<Passagem> passagens = new ArrayList<>();
    // Lista de assentos disponíveis originalmente
    private List<String> assentos = new ArrayList<>();
    // Set estático para IDs únicos de voos
    private static final Set<Integer> idExistentes = new HashSet<>();

    /**
     * Construtor do Voo.
     * @param partida Cidade de origem
     * @param destino Cidade destino
     * @param capacidade Número de assentos
     */
    public Voo(String partida, String destino, int capacidade) {
        this.partida = partida;
        this.destino = destino;
        this.capacidade = capacidade;
        this.id = gerarId();
        // Gera lista de assentos A1, A2, ..., An baseado na capacidade
        for (int i = 0; i < capacidade; i++) {
            assentos.add("A" + (i + 1));
        }
    }

    /**
     * Gera ID único para o voo (1-999, menor range que passagens).
     * Mesmo padrão: loop até único.
     */
    private int gerarId() {
        int id;
        do {
            id = ThreadLocalRandom.current().nextInt(1, 1000);
        } while (!idExistentes.add(id));
        return id;
    }

    /**
     * Verifica se um assento está na lista original (disponível conceitualmente).
     * Nota: não remove de assentos, só marca reservado em outra lista.
     */
    public boolean assentoDisponivel(String assento) {
        // Checa se existe na lista master de assentos deste voo
        return assentos.contains(assento);
    }

    /**
     * Reserva um assento se disponível.
     * Lógica um pouco redundante: checa se já reservado, depois procura na lista assentos (que é fixa) para add a reservadas.
     * Imprime erro se já reservado.
     */
    public boolean reservarAssento(String assento) {
        if (!assentosReservados.contains(assento)) {  // Já reservado? Sai fora
            // Procura o assento na lista original (desnecessário se validado antes, mas ok)
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

    /**
     * Lista reservas/passagens para um destino específico.
     * ATENÇÃO: implementação incompleta - corpo vazio.
     * Deveria iterar passagens e filtrar por destino.
     */
    public void listarReservas(String destino) {
        if (!passagens.isEmpty()) {
            // TODO: implementar listagem filtrada por destino
        } else {
            // TODO: mensagem "sem reservas"
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

    /**
     * Representação do voo para impressão.
     * Inclui ID, rota, capacidade e lista de assentos reservados.
     */
    @Override
    public String toString() {
        return String.format("Id do Voo: %d, Partida: %s, Destino: %s, Capacidade do voo: %d, Reservas do voo: %s", id, partida, destino, capacidade, assentosReservados);
    }

}
