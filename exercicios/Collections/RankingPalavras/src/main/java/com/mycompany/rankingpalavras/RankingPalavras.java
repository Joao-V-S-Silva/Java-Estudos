/*
 Enunciado:
 Crie um programa que receba uma frase digitada pelo usuário e conte quantas vezes cada palavra aparece.
  Regras:
    - Ignore maiúsculas e minúsculas.
    - Utilize um Map para armazenar cada palavra e sua contagem.
    - Exiba as palavras em ordem de maior para menor frequência.
 Objetivo: praticar o uso de Map e contagem de elementos repetidos.
 */
package com.mycompany.rankingpalavras;

import java.text.Normalizer;
import java.util.*;
import java.util.Map.Entry;

public class RankingPalavras {

    public static void main(String[] args) {

        // --- Declarações iniciais ---
        // regex: divide o texto por qualquer caractere que NÃO seja letra (\p{L}) ou número (\p{N})
        String fraseDigitada, regex = "[^\\p{L}\\p{N}]+";
        String[] split;

        // LinkedHashMap mantém a ordem de inserção (útil se quiser preservar a sequência original)
        Map<String, Integer> palavrasDigitadas = new LinkedHashMap<>();

        Scanner EntradaDados = new Scanner(System.in);
        System.out.print("Digite a frase para verificar o Ranking de palavras: ");

        // --- Leitura da frase ---
        fraseDigitada = EntradaDados.nextLine();

        // --- Validação de entrada ---
        if (fraseDigitada == null || fraseDigitada.isEmpty()) {
            System.out.println("A frase digitada está nula ou em branco, verifique!");
            return; // encerra o programa
        } else {
            // --- Normalização de texto ---
            // Remove acentos: decompõe e elimina marcas de acentuação
            fraseDigitada = Normalizer.normalize(fraseDigitada, Normalizer.Form.NFD);
            fraseDigitada = fraseDigitada.replaceAll("\\p{M}+", "");

            // Transforma tudo em minúsculo para padronizar
            fraseDigitada = fraseDigitada.toLowerCase();
        }

        // --- Divisão da frase em palavras ---
        // trim remove espaços externos, split usa regex para separar por símbolos e espaços
        split = fraseDigitada.trim().split(regex);

        // --- Contagem de palavras ---
        // merge() insere com valor 1 se nova palavra, ou soma +1 se já existir
        for (String split1 : split) {
            if (!split1.isEmpty()) { // evita entradas vazias
                palavrasDigitadas.merge(split1, 1, (antigoValor, novoValor) -> antigoValor + novoValor);
            }
        }

        // --- Conversão em lista para ordenar ---
        List<Entry<String, Integer>> ranking = new ArrayList<>(palavrasDigitadas.entrySet());

        // Ordena por valor (frequência), em ordem decrescente
        ranking.sort(Entry.<String, Integer>comparingByValue().reversed());

        // --- Exibição do resultado ---
        System.out.println("\n=== Ranking de Palavras ===");
        for (Entry<String, Integer> e : ranking) {
            System.out.printf("%-15s -> %d\n", e.getKey(), e.getValue());
        }

        EntradaDados.close(); // boa prática: fecha o Scanner
    }
}
