/*
Enunciado:
Crie uma lista de pessoas com nome e idade, e agrupe-as por idade em um Map.
Regras:
    - A chave do mapa deve ser a idade.
    - O valor deve ser uma lista com todas as pessoas dessa idade.
    - Exiba o resultado mostrando as idades e os nomes correspondentes.
Objetivo: Entender como agrupar objetos com base em um atributo.
 */
package com.mycompany.agrupamentodepessoas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgrupamentoDePessoas {

    public static void main(String[] args) {
        // Cria uma lista para armazenar as pessoas
        List<Pessoa> pessoas = new ArrayList<>();

        // Cria um mapa onde:
        // - Chave: Integer (a idade)
        // - Valor: List<String> (lista de nomes das pessoas com essa idade)
        Map<Integer, List<String>> agrupamentoPorIdade = new HashMap<>();

        // Adiciona as pessoas na lista com diferentes idades
        pessoas.add(new Pessoa("Alice", 30));
        pessoas.add(new Pessoa("Bob", 25));
        pessoas.add(new Pessoa("Charlie", 30));
        pessoas.add(new Pessoa("David", 25));

        // Percorre cada pessoa da lista para fazer o agrupamento
        for (Pessoa pessoa : pessoas) {
            // Extrai a idade da pessoa atual
            int idade = pessoa.getIdade();

            // Verifica se essa idade já existe como chave no mapa
            if (agrupamentoPorIdade.containsKey(idade)) {
                // Se a idade JÁ EXISTE no mapa:
                // - get(idade) retorna a lista de nomes já existente para essa idade
                // - add() adiciona o nome da pessoa atual nessa lista
                agrupamentoPorIdade.get(idade).add(pessoa.getNome());
                System.out.println("Pessoa com idade " + idade + " já existe no agrupamento. Adicionando "
                        + pessoa.getNome() + " à lista.");
            } else {
                // Se a idade NÃO EXISTE no mapa:
                // 1. Cria uma nova lista vazia
                List<String> nomes = new ArrayList<>();
                // 2. Adiciona o nome da pessoa nessa nova lista
                nomes.add(pessoa.getNome());
                // 3. Guarda a lista no mapa com a idade como chave
                agrupamentoPorIdade.put(idade, nomes);
                System.out.println("Pessoa com idade " + idade + " adicionada ao agrupamento: " + pessoa.getNome());
            }
        }

        // Exibe o resultado final do agrupamento
        System.out.println("\nAgrupamento por idade:");
        // Percorre cada entrada do mapa (cada idade e sua lista de pessoas)
        for (Map.Entry<Integer, List<String>> entry : agrupamentoPorIdade.entrySet()) {
            // entry.getKey() = a idade (Integer)
            // entry.getValue() = a lista de nomes (List<String>)
            System.out.println("Idade: " + entry.getKey() + " - Pessoas: " + entry.getValue());
        }
    }
}
