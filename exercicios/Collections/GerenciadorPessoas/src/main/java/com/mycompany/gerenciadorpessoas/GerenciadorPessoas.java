// Pacote do projeto
package com.mycompany.gerenciadorpessoas;

// Importações necessárias para trabalhar com listas e mapas
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Classe principal do programa
public class GerenciadorPessoas {

    // Método principal (ponto de entrada do programa)
    public static void main(String[] args) {
        // Lista para armazenar todas as pessoas cadastradas
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        // Mapa que associa uma cidade (String) a uma lista de pessoas daquela cidade
        Map<String, ArrayList<Pessoa>> mapa = new HashMap();

        // Cadastro de várias pessoas com nome e cidade
        cadastrarPessoa(pessoas, "João", "São Paulo");
        cadastrarPessoa(pessoas, "Maria", "São Paulo");
        cadastrarPessoa(pessoas, "Pedro", "São Paulo");
        cadastrarPessoa(pessoas, "Ana", "São Paulo");
        cadastrarPessoa(pessoas, "Bruno", "Rio de Janeiro");
        cadastrarPessoa(pessoas, "Carla", "Rio de Janeiro");
        cadastrarPessoa(pessoas, "Diego", "Rio de Janeiro");
        cadastrarPessoa(pessoas, "Elisa", "Belo Horizonte");
        cadastrarPessoa(pessoas, "Fernando", "Belo Horizonte");
        cadastrarPessoa(pessoas, "Gabriel", "Belo Horizonte");

        // Exibe todas as pessoas cadastradas na lista
        listarPessoas(pessoas);

        // Preenche o mapa com pessoas agrupadas por cidade
        cadastrarPessoasPorCidade(pessoas, mapa);

        // Exibe as pessoas agrupadas por cidade
        listarPessoasPorCidade(mapa);
    }

    // Método para cadastrar uma nova pessoa na lista
    public static void cadastrarPessoa(ArrayList<Pessoa> listaPessoas, String nome, String cidade) {
        try {
            // Verifica se o nome ou a cidade são nulos ou vazios
            if (nome == null || nome.isBlank() || cidade == null || cidade.isBlank()) {
                throw new IllegalArgumentException("Cidade ou nome não podem ser nulos/vazio");
            } else {
                // Cria nova Pessoa e adiciona à lista
                listaPessoas.add(new Pessoa(nome, cidade));
            }
        } catch (IllegalArgumentException e) {
            // Mostra mensagem de erro caso os dados sejam inválidos
            System.err.println("Ocorreu um erro ao cadastrar uma pessoa: " + e.getMessage());
        }
    }

    // Método para listar todas as pessoas da lista
    public static void listarPessoas(ArrayList<Pessoa> listaPessoas) {
        if (listaPessoas.isEmpty()) {
            System.out.println("A lista de pessoas está vazia.");
        } else {
            // Imprime cada pessoa usando o toString da classe Pessoa
            System.out.println("Lista de todas as pessoas");
            listaPessoas.forEach(System.out::println);
        }
    }

    // Método que agrupa pessoas por cidade e armazena no mapa
    public static void cadastrarPessoasPorCidade(ArrayList<Pessoa> listaPessoas, Map<String, ArrayList<Pessoa>> mapa) {
        if (listaPessoas.isEmpty()) {
            System.out.println("A lista de pessoas está vazia");
        } else {
            // Para cada pessoa, adiciona ela na lista da cidade correspondente no mapa
            for (Pessoa pessoa : listaPessoas) {
                // computeIfAbsent garante que uma lista exista para a cidade, ou cria uma nova se não existir
                mapa.computeIfAbsent(pessoa.getCidade(), cidade -> new ArrayList<>()).add(pessoa);
                System.out.printf("Pessoa %s adicionada no mapa da cidade %s\n", pessoa.getNome(), pessoa.getCidade());
            }
        }
    }

    // Método que exibe as pessoas organizadas por cidade
    public static void listarPessoasPorCidade(Map<String, ArrayList<Pessoa>> mapa) {
        // Para cada cidade (chave do mapa)
        for (String key : mapa.keySet()) {
            System.out.println("Cidade: " + key);
            // Imprime todas as pessoas associadas a essa cidade
            for (Pessoa pessoa : mapa.get(key)) {
                System.out.println("- " + pessoa); // Usa o toString da classe Pessoa
            }
            System.out.println("");
        }

        /*
        Versão alternativa usando forEach com lambda:
        mapa.forEach((cidade, lista) -> {
            System.out.println("Cidade: " + cidade);
            lista.forEach(pessoa -> System.out.println(pessoa.toString()));
        });
         */
    }
}
