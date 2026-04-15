/*
Enunciado:
Crie um programa que receba um dicionário (Map) de pares chave-valor e gere um novo mapa invertendo as posições.
Regras:
    - A chave deve se tornar o valor e o valor deve se tornar a chave.
    - Caso existam valores repetidos, mantenha apenas o primeiro encontrado
Objetivo:
    Reforçar a manipulação de mapas e iteração sobre entradas.
 */
package com.mycompany.dicionarioinvertido;

import java.util.HashMap;
import java.util.Map;

// Classe principal do programa
public class DicionarioInvertido {

    // Método principal
    public static void main(String[] args) {

        /*
         * Mapa original (dicionário)
         * String → chave
         * String → valor
         */
        Map<String, String> dicionario = new HashMap<>();

        /*
         * Mapa que armazenará o dicionário invertido
         * Aqui a chave será o valor original
         * e o valor será a chave original
         */
        Map<String, String> dicionarioInvertido = new HashMap<>();

        // Inserindo dados no dicionário original
        dicionario.put("Olá", "Mundo");
        dicionario.put("João", "Nicolas");
        dicionario.put("Teste", "Belo");

        /*
         * Percorre todas as entradas do mapa original
         * entry.getKey()   → chave original
         * entry.getValue() → valor original
         */
        for (Map.Entry<String, String> entry : dicionario.entrySet()) {
            String chave = entry.getKey();
            String valor = entry.getValue();

            /*
             * Inverte chave e valor.
             * O método putIfAbsent garante que,
             * se houver valores repetidos,
             * apenas o primeiro seja mantido.
             */
            dicionarioInvertido.putIfAbsent(valor, chave);
        }

        // Exibe os mapas no console
        System.out.println("Dicionário original:");
        System.out.println(dicionario);

        System.out.println("Dicionário invertido:");
        System.out.println(dicionarioInvertido);
    }
}
