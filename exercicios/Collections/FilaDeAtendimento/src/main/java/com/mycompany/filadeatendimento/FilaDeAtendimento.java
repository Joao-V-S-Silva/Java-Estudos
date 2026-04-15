/*
Enunciado:
Implemente uma fila simples de atendimento ao cliente.
Regras:
    - Permita adicionar novos clientes à fila.
    - Permita remover clientes conforme forem sendo atendidos.
    - Sempre exiba quem é o próximo da fila.
    - Se a fila estiver vazia, mostre uma mensagem especial.
Objetivo: praticar o uso de Queue e métodos de adição e remoção.
 */
package com.mycompany.filadeatendimento;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FilaDeAtendimento {

    // Scanner compartilhado para leitura de dados do usuário
    public static Scanner entradaDados = new Scanner(System.in);
    // Estrutura de fila FIFO (primeiro que entra, primeiro que sai)
    public static Queue<String> fila = new LinkedList<>();
    // Armazena temporariamente o nome do cliente digitado
    public static String cliente;

    public static void main(String[] args) {

        boolean encerrado = false; // controla o loop principal do menu

        // Laço principal do sistema, roda até o usuário escolher encerrar
        while (!encerrado) {
            try {

                // Exibição do menu de opções
                System.out.println("\nMenu:");
                System.out.println("[1] - Adicionar Cliente");
                System.out.println("[2] - Atender Cliente");
                System.out.println("[3] - Listar Clientes");
                System.out.println("[0] - Encerrar sistema");
                System.out.print("Opção: ");

                // Captura a opção do usuário
                int opcao = entradaDados.nextInt();
                entradaDados.nextLine(); // limpa buffer após leitura numérica

                // Controle de fluxo conforme a opção escolhida
                switch (opcao) {
                    case 1:
                        adicionarCliente(); // adiciona novo cliente à fila
                        break;
                    case 2:
                        atenderProxCliente(); // remove e mostra o cliente atendido
                        break;
                    case 3:
                        mostrarFilaClientes(); // exibe estado atual da fila
                        break;
                    case 0:
                        encerrado = true; // encerra o loop principal
                        System.out.println("Encerrando...");
                        break;
                    default:
                        // Caso o usuário digite uma opção inexistente
                        System.out.println("Digite uma opção válida!");
                        break;
                }

            } catch (InputMismatchException e) {
                // Captura erro de entrada quando o usuário digita algo não numérico
                System.out.println("Opção inválida, verifique!");
                entradaDados.nextLine(); // limpa o buffer e evita loop infinito
            }
        }
    }

    // Adiciona novo cliente à fila, caso o nome seja válido
    public static void adicionarCliente() {
        System.out.print("Digite o cliente que será adicionado a fila: ");
        cliente = entradaDados.nextLine();

        // Evita adicionar nomes vazios ou nulos na fila
        if (cliente == null || cliente.isEmpty()) {
            System.out.println("Cliente informado nulo ou vazio, verifique!");
        } else {
            fila.offer(cliente); // método offer() adiciona elemento ao final da fila
            System.out.printf("Cliente [%s] adicionado com sucesso!\n", cliente);
        }
    }

    // Remove o próximo cliente da fila e exibe quem é o próximo
    public static void atenderProxCliente() {
        // Verifica se há alguém na fila antes de atender
        if (fila.isEmpty()) {
            System.out.println("Fila de atendimento vazia!");
        } else {
            // poll() remove e retorna o primeiro cliente da fila
            System.out.printf("Cliente [%s] atendido com sucesso!\n", fila.poll());

            // peek() mostra o próximo cliente sem removê-lo
            if (fila.peek() != null) {
                System.out.printf("Proximo cliente a ser atendido: [%s]\n", fila.peek());
            } else {
                // Caso a fila esvazie após o atendimento
                System.out.println("Fila de atendimento vazia!");
            }
        }
    }

    // Exibe o conteúdo atual da fila
    public static void mostrarFilaClientes() {
        // Garante mensagem adequada quando não há clientes
        if (fila.isEmpty()) {
            System.out.println("Fila de clientes vazia!");
        } else {
            System.out.println("Fila de clientes: " + fila);
        }
    }
}
