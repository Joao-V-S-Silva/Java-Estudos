package com.mycompany.divisaocomtratamento;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisaoComTratamento {

    static Scanner entradaDados = new Scanner(System.in);

    public static void main(String[] args) {
        int n1 = 0, n2 = 0;
        float resultado = 0;
        System.out.printf("Digite o 1° número: ");
        n1 = validarEntrada();
        System.out.printf("Digite o 2° número: ");
        n2 = validarEntrada();
        try {
            resultado = n1 / n2;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Erro: Não é possível dividir por zero!");
        }
    }

    public static int validarEntrada() {
        while (true) {
            try {
                return entradaDados.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número inteiro:");
                entradaDados.next(); // limpa o valor errado
            }
        }
    }
}
