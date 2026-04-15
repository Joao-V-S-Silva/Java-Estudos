package com.mycompany.gestordereservas;

/**
 * Classe principal - demonstra o sistema de reservas de voos.
 * Cria passageiros, voos, passagens, testa reservas, cancelamento e listagem.
 */
public class GestorDeReservas {
    
    /**
     * Método main - ponto de entrada do demo.
     * Cria objetos, faz reservas, imprime estados, cancela uma e lista.
     */
    public static void main(String[] args) {
        // Cria 2 passageiros com dados básicos (nome, sexo, idade)
        Passageiro passageiro1 = new Passageiro("João", "M", 23);
        Passageiro passageiro2 = new Passageiro("Maria", "F", 22);
        // Cria 2 voos João Pessoa -> Recife com capacidades diferentes
        Voo voo1 = new Voo("João Pessoa", "Recife", 50);
        Voo voo2 = new Voo("João Pessoa", "Recife", 20);
        // Cria 3 passagens: 2 em voos diferentes, 1 extra no voo1 para João A3
        Passagem passagem1 = new Passagem(voo1, passageiro1, "A1");
        Passagem passagem2 = new Passagem(voo2, passageiro2, "A3");
        Passagem passagem3 = new Passagem(voo1, passageiro1, "A3");
        // Imprime passageiros (nome, sexo, idade, ID)
        System.out.println(passageiro1);
        System.out.println(passageiro2);
        // Imprime reservas do voo1 (assentos reservados)
        System.out.println(voo1.getReservas());
        // Imprime voo2 completo
        System.out.println(voo2);
        // Imprime as 3 passagens (detalhes reserva)
        System.out.println(passagem1);
        System.out.println(passagem2);
        System.out.println(passagem3);
        // Cancela a 3a passagem usando seu ID
        passagem3.cancelarReserva(passagem3.getIdReserva());
        // Tenta listar reservas do voo1 para "Recife" (método incompleto)
        voo1.listarReservas("Recife");
    }
}
