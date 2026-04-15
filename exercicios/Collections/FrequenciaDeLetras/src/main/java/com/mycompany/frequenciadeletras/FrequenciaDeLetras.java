/*
Crie um programa que conte quantas vezes cada letra aparece em uma palavra ou frase.
Regras:
- Ignore espaços e pontuações.
- As letras devem ser armazenadas como chaves e as quantidades como valores.
- Exiba o resultado em ordem alfabética das letras.
Objetivo: reforçar a contagem de ocorrências com Map e manipulação de strings.
 */

package com.mycompany.frequenciadeletras;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author joaov
 */
public class FrequenciaDeLetras {

    public static void main(String[] args) {
        // Scanner para ler a frase digitada pelo usuário
        Scanner entradaDados = new Scanner(System.in);

        // Mapa de frequência: chave = letra; valor = contagem de ocorrências
        Map<Character, Integer> frequenciaLetras = new HashMap<>();

        // Variável que receberá a frase de entrada
        String frase;

        System.out.println("Digite uma frase: ");

        // Lê a frase completa com espaços
        frase = entradaDados.nextLine();

        // Converte tudo para minúsculas para contar 'A' e 'a' juntas
        frase = frase.toLowerCase();

        // Percorre cada caractere da frase
        for (char letra : frase.toCharArray()) {

            // Processa somente letras, ignorando espaços e pontuação
            if (Character.isLetter(letra)) {

                // Se a letra já está no mapa, incrementa o contador
                if (frequenciaLetras.containsKey(letra)) {
                    frequenciaLetras.put(letra, frequenciaLetras.get(letra) + 1);
                    System.out.println("Letra adicionada: " + letra); // feedback opcional
                } else {
                    // Se for a primeira ocorrência, adiciona com valor 1
                    frequenciaLetras.put(letra, 1);
                    System.out.println("Letra adicionada: " + letra); // feedback opcional
                }
            }
        }

        // Ordena as letras em ordem alfabética usando TreeMap
        Map<Character, Integer> frequenciaOrdenada = new TreeMap<>(frequenciaLetras);

        // Exibe resultado final em ordem alfabética (requisito da questão 9)
        frequenciaOrdenada.entrySet().forEach(entry -> {
            System.out.println("Letra: " + entry.getKey() + " - Frequência: " + entry.getValue());
        });

        // Fecha o Scanner para evitar vazamento de recurso
        entradaDados.close();
    }
}
