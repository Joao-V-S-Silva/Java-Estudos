// Pacote onde a classe está localizada
package com.mycompany.ordenacaonumeros;

// Importações necessárias
import java.security.SecureRandom; // Para gerar números aleatórios de forma mais segura
import java.util.ArrayList;        // Lista dinâmica
import java.util.Collections;      // Utilitário para ordenação de listas
import java.util.List;             // Interface de lista
import java.util.stream.Collectors; // Para trabalhar com Stream API

public class OrdenacaoNumeros {

    public static void main(String[] args) {
        // Criação de uma lista de inteiros vazia
        List<Integer> numeros = new ArrayList<>();

        // Objeto para gerar números aleatórios de forma segura
        SecureRandom random = new SecureRandom();

        // Gera 10 números aleatórios entre 1 e 100 e adiciona na lista
        for (int i = 0; i < 10; i++) {
            numeros.add(random.nextInt(100) + 1); // nextInt(100) gera de 0 a 99, por isso soma 1
        }

        // Filtra os números pares da lista original usando Stream e salva em uma nova lista
        List<Integer> numerosPares = numeros.stream()
                .filter(n -> n % 2 == 0) // Condição para número par
                .collect(Collectors.toList()); // Coleta os pares em uma nova lista

        // Exibe a lista original (não ordenada)
        System.out.println("Lista Original");
        numeros.forEach(n -> System.out.printf("{%d} ", n)); // Imprime cada número com chaves

        System.out.println(""); // Linha em branco para separar

        // Ordena a lista original
        Collections.sort(numeros);

        // Exibe a lista original agora ordenada
        System.out.println("Lista Ordenada");
        numeros.forEach(n -> System.out.printf("{%d} ", n));

        System.out.println(""); // Linha em branco

        // Exibe a lista de números pares (não ordenada)
        System.out.println("Lista de números pares");
        numerosPares.forEach(n -> System.out.printf("{%d} ", n));

        System.out.println(""); // Linha em branco

        // Ordena a lista de números pares
        Collections.sort(numerosPares);

        // Exibe a lista de números pares ordenada
        System.out.println("Lista de números pares ordenada");
        numerosPares.forEach(n -> System.out.printf("{%d} ", n));
    }
}
