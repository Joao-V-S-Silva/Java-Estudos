/*
 * Projeto: ArrayNomesComTratamento
 * Objetivo: Exibir uma lista de nomes e permitir que o usuário acesse um nome
 * através do índice informado no console.
 * O programa trata dois tipos de exceções:
 *  - ArrayIndexOutOfBoundsException: quando o índice digitado não existe no array.
 *  - InputMismatchException: quando o usuário digita algo que não seja número inteiro.
 * O programa repete a solicitação até o usuário digitar corretamente.
 */
package com.mycompany.arraynomescomtratamento;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayNomesComTratamento {

    public static void main(String[] args) {
        // Array de nomes fixos
        String nomes[] = {"João", "Maria", "Henrique", "Pedro", "Mariana"};
        int indiceDigitado = 0;
        boolean nomeEncontrado = false;
        Scanner entradaDados = new Scanner(System.in);

        // Exibe os nomes disponíveis com seus respectivos índices
        System.out.println("Nomes disponíveis:");
        for (int i = 0; i < nomes.length; i++) {
            System.out.printf("[%d] %s\n", i, nomes[i]);
        }

        // Loop até o usuário digitar um índice válido
        while (!nomeEncontrado) {
            try {
                System.out.printf("Digite um número para buscar o nome pelo índice: ");
                indiceDigitado = entradaDados.nextInt(); // pode lançar InputMismatchException
                System.out.printf("Nome encontrado: %S\n", nomes[indiceDigitado]); // pode lançar ArrayIndexOutOfBoundsException
                nomeEncontrado = true; // encerra o loop se tudo ocorrer bem
            } catch (ArrayIndexOutOfBoundsException e) {
                // Trata o erro quando o número está fora do tamanho do array
                System.out.println("Erro: Índice inválido no array, verifique !");
            } catch (InputMismatchException e) {
                // Trata o erro quando o usuário digita algo que não seja número inteiro
                System.out.println("Erro: entrada inválida, verifique !");
                entradaDados.next(); // limpa a entrada inválida para evitar loop infinito
            }
        }

        entradaDados.close();
    }
}
