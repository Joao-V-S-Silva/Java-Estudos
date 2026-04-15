/*
 Enunciado:
 Crie uma interface genérica para representar um repositório de dados.

 Regras:
     - Deve conter métodos para salvar, buscar e deletar objetos por ID.
     - Implemente uma versão em memória utilizando um Map para armazenar os dados.
     - Teste o repositório com tipos diferentes (por exemplo, Aluno, Produto, etc.).

 Objetivo:
     Praticar o uso de interfaces e implementação genérica.
 */
package com.mycompany.repositoriogenerico;

// Classe principal para testes do repositório genérico
public class RepositorioGenerico {

    // Método principal da aplicação
    public static void main(String[] args) {

        /*
         * Repositório de alunos
         * Integer → tipo do ID
         * String  → tipo do valor armazenado
         */
        RepositorioEmMemoria<Integer, String> alunos = new RepositorioEmMemoria<>();

        /*
         * Repositório de produtos
         * Integer → tipo do ID
         * String  → tipo do valor armazenado
         */
        RepositorioEmMemoria<Integer, String> produtos = new RepositorioEmMemoria<>();

        // Salvando alunos no repositório
        alunos.salvar(1, "João");
        alunos.salvar(2, "Mariana");
        alunos.salvar(3, "Nicolas");

        // Exibindo alunos cadastrados
        System.out.println("Banco de dados de alunos:");
        System.out.println("==========");
        System.out.print(alunos.buscarTodos());
        System.out.println("==========");

        // Salvando produtos no repositório
        produtos.salvar(1, "Tomate");
        produtos.salvar(2, "Cebola");
        produtos.salvar(3, "Pimentão");

        // Exibindo produtos cadastrados
        System.out.println("Banco de dados de produtos:");
        System.out.println("==========");
        System.out.print(produtos.buscarTodos());
        System.out.println("==========");
    }
}
