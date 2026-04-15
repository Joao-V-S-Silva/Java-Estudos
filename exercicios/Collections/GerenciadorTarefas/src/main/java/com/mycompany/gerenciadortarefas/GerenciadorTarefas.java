// Classe principal responsável por gerenciar uma lista de tarefas.
// Permite adicionar, concluir, listar e remover tarefas concluídas.
package com.mycompany.gerenciadortarefas;

import java.util.ArrayList;
import java.util.Iterator;

public class GerenciadorTarefas {

    public static void main(String[] args) {
        // Cria a lista que armazenará as tarefas
        ArrayList<Tarefas> listaTarefas = new ArrayList<>();

        // Adiciona várias tarefas à lista
        adicionarTarefa(listaTarefas, "Estudar Java");
        adicionarTarefa(listaTarefas, "Fazer compras");
        adicionarTarefa(listaTarefas, "Limpar casa");
        adicionarTarefa(listaTarefas, "Enviar e-mail");
        adicionarTarefa(listaTarefas, "Ler livro");
        adicionarTarefa(listaTarefas, "Pagar contas");
        adicionarTarefa(listaTarefas, "Caminhar");
        adicionarTarefa(listaTarefas, "Revisar código");

        // Marca algumas tarefas como concluídas
        concluirTarefa(listaTarefas, "Revisar código");
        concluirTarefa(listaTarefas, "Pagar contas");
        concluirTarefa(listaTarefas, "Caminhar");
        concluirTarefa(listaTarefas, "Estudar Java");

        // Exibe todas as tarefas
        listarTarefas(listaTarefas);
        System.out.println("");

        // Remove todas as tarefas que estão marcadas como concluídas
        removerTarefaConcluida(listaTarefas);
        System.out.println("");

        // Exibe novamente a lista, agora sem as concluídas
        listarTarefas(listaTarefas);
        System.out.println("");
    }

    // Método para adicionar uma nova tarefa à lista
    public static void adicionarTarefa(ArrayList<Tarefas> listaTarefas, String tarefa) {
        try {
            // Verifica se a string da tarefa é nula ou vazia
            if (tarefa == null || tarefa.isBlank()) {
                throw new IllegalArgumentException("Tarefa não pode ser nulo ou vazio");
            } else {
                // Adiciona a nova tarefa à lista
                listaTarefas.add(new Tarefas(tarefa));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar tarefa" + e.getMessage());
        }
    }

    // Método para marcar uma tarefa como concluída
    public static void concluirTarefa(ArrayList<Tarefas> listaTarefas, String tarefa) {
        try {
            // Verifica se a string da tarefa é nula ou vazia
            if (tarefa == null || tarefa.isBlank()) {
                throw new IllegalArgumentException("Tarefa não pode ser nulo ou vazio");
            } else {
                // Percorre a lista em busca da tarefa com o mesmo título
                for (int i = 0; i < listaTarefas.size(); i++) {
                    if (tarefa.equalsIgnoreCase(listaTarefas.get(i).getTitulo())) {
                        // Marca como concluída e encerra a busca
                        listaTarefas.get(i).setConcluido(true);
                        System.out.println("Tarefa concluída com sucesso");
                        return;
                    }
                }
                // Caso nenhuma tarefa seja encontrada
                System.out.println("Tarefa não encontrada, verifique");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao concluir tarefa" + e.getMessage());
        }
    }

    // Método para exibir todas as tarefas da lista
    public static void listarTarefas(ArrayList<Tarefas> listaTarefas) {
        if (listaTarefas.isEmpty()) {
            System.out.println("A lista de tarefas está vazia");
        } else {
            // Percorre a lista e imprime cada tarefa
            for (Tarefas listaTarefa : listaTarefas) {
                System.out.println(listaTarefa);
            }
        }
    }

    // Método para remover todas as tarefas que foram concluídas
    public static void removerTarefaConcluida(ArrayList<Tarefas> listaTarefas) {
        int removidas = 0; // Contador de tarefas removidas
        Iterator<Tarefas> it = listaTarefas.iterator();

        // Percorre a lista usando Iterator para permitir remoção segura
        while (it.hasNext()) {
            Tarefas nomeTarefa = it.next();
            if (nomeTarefa.isConcluido()) {
                it.remove(); // Remove a tarefa concluída
                removidas++;
                System.out.printf("Tarefa %s removida com sucesso\n", nomeTarefa.getTitulo());
            }
        }

        // Exibe mensagem dependendo se tarefas foram removidas ou não
        if (removidas == 0) {
            System.out.println("Tarefa não encontrada ou não concluída, verifique");
        } else {
            System.out.printf("Total de tarefas removidas: %d\n", removidas);
        }
    }
}
