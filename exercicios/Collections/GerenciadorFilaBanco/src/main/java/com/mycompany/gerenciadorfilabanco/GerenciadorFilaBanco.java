/*
 * Este programa simula o gerenciamento de uma fila de atendimento em um banco usando a interface Queue do Java.
 * Ele permite adicionar clientes à fila, listar todos os clientes na fila, atender o próximo cliente,
 * e visualizar quem será o próximo cliente a ser atendido.
 * 
 * A fila é implementada usando a classe LinkedList, que mantém a ordem de inserção dos elementos.
 * O primeiro cliente adicionado será o primeiro a ser atendido (FIFO - First In, First Out).
 */
package com.mycompany.gerenciadorfilabanco;

import java.util.LinkedList;
import java.util.Queue;

public class GerenciadorFilaBanco {

    public static void main(String[] args) {
        // Criação da fila de clientes utilizando LinkedList
        Queue<String> clientes = new LinkedList();

        // Adicionando clientes à fila
        adicionarCliente(clientes, "João");
        adicionarCliente(clientes, "Maria");
        adicionarCliente(clientes, "Pedro");
        adicionarCliente(clientes, "Ana");
        adicionarCliente(clientes, "Bruno");

        // Listando todos os clientes na fila
        listarClientes(clientes);

        // Atendendo o primeiro cliente da fila (FIFO)
        atenderCliente(clientes);

        // Adicionando um novo cliente à fila após o atendimento
        adicionarCliente(clientes, "Carla");

        // Listando novamente os clientes na fila após modificações
        listarClientes(clientes);

        // Mostrando quem será o próximo cliente a ser atendido
        proximoCliente(clientes);
    }

    // Método para adicionar um cliente à fila
    public static void adicionarCliente(Queue<String> listaClientes, String cliente) {
        try {
            // Validação para evitar cliente nulo ou em branco
            if (cliente == null || cliente.isBlank()) {
                throw new IllegalArgumentException("Cliente não pode ser nulo ou vazio");
            } else {
                // Adiciona o cliente ao final da fila
                listaClientes.offer(cliente);
                System.out.printf("Cliente %s adicionado à fila\n", cliente);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar o cliente: " + e.getMessage());
        }
    }

    // Método para atender (remover) o próximo cliente da fila
    public static void atenderCliente(Queue<String> listaClientes) {
        try {
            // Verifica se a fila está vazia antes de tentar atender
            if (listaClientes.isEmpty()) {
                throw new IllegalArgumentException("Nenhum cliente na fila de atendimento");
            } else {
                // Remove e mostra o cliente que está sendo atendido
                System.out.printf("Atendendo cliente: %s\n", listaClientes.poll());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao atender cliente: " + e.getMessage());
        }
    }

    // Método para listar todos os clientes atualmente na fila
    public static void listarClientes(Queue<String> listaClientes) {
        try {
            // Verifica se há clientes na fila
            if (listaClientes.isEmpty()) {
                throw new IllegalArgumentException("Nenhum cliente na fila de atendimento");
            } else {
                System.out.println("Clientes na fila: ");
                // Itera e exibe todos os clientes na fila
                for (String listaCliente : listaClientes) {
                    System.out.println("- " + listaCliente);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao listar cliente: " + e.getMessage());
        }
    }

    // Método para visualizar o próximo cliente da fila sem removê-lo
    public static void proximoCliente(Queue<String> listaClientes) {
        try {
            // Verifica se a fila está vazia
            if (listaClientes.isEmpty()) {
                throw new IllegalArgumentException("Nenhum cliente na fila de atendimento");
            } else {
                // Mostra o cliente que será o próximo a ser atendido
                System.out.printf("Próximo cliente a ser atendido: %s \n", listaClientes.peek());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao carregar o próximo cliente: " + e.getMessage());
        }
    }
}
