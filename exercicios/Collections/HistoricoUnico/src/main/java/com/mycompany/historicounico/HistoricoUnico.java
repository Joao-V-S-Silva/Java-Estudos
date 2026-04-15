/*
Enunciado:
Simule um histórico de URLs visitadas por um usuário.
Regras:
    - Armazene as URLs em um Set para evitar duplicatas.
    - Caso o usuário tente adicionar uma URL repetida, exiba uma mensagem de aviso.
    - Mostre o histórico final ordenado alfabeticamente.
Objetivo: entender como o Set lida com elementos únicos e ordenação.
 */
package com.mycompany.historicounico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HistoricoUnico {

    public static void main(String[] args) {
        boolean encerrar = false;
        int opcao = 1;
        Scanner entradaDados = new Scanner(System.in);
        // HashSet garante URLs únicas (sem duplicatas)
        HashSet<String> urls = new HashSet<>();

        while (!encerrar) {
            try {
                System.out.println("\nMenu:");
                System.out.println("[1] - Adicionar URL");
                System.out.println("[0] - Sair");
                System.out.print("Opção: ");
                opcao = entradaDados.nextInt();
                entradaDados.nextLine(); // limpa buffer do Scanner após nextInt()

                switch (opcao) {
                    case 1 -> {
                        System.out.print("Digite uma URL a ser adicionada: ");
                        String urlDigitada = entradaDados.nextLine();

                        if (urlDigitada == null || urlDigitada.isEmpty()) {
                            System.out.println("A URL digitada é nula ou em branco. Verifique!");
                        } else {
                            // add() retorna false se já existir no Set
                            System.out.println(
                                    urls.add(urlDigitada)
                                    ? "URL adicionada com sucesso!"
                                    : "URL já existe, verifique!"
                            );
                        }
                    }

                    case 0 -> {
                        System.out.println("Encerrando...");
                        encerrar = true;
                    }

                    default ->
                        System.out.println("Opção inválida!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Opção inválida, verifique!");
                entradaDados.nextLine(); // limpa o buffer e evita loop infinito
            }
        }

        /*
         * Aqui o HashSet é convertido para uma lista (ArrayList),
         * permitindo ordenação manual via Collections.sort().
         * Isso demonstra como podemos ordenar elementos
         * mesmo quando o Set não mantém ordem naturalmente.
         */
        
        List<String> urlsOrdenada = new ArrayList<>(urls);
        Collections.sort(urlsOrdenada);
        System.out.println("Lista de URLs ordenada: " + urlsOrdenada);
        // Se quiser apenas exibir o Set sem ordenar:
        //System.out.println("Histórico (sem ordenação garantida): " + urls);

        entradaDados.close();
    }
}
