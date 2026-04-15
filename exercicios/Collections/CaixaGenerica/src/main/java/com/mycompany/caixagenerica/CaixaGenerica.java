/*
Enunciado:
Crie uma classe genérica chamada Caixa que possa guardar qualquer tipo de objeto.
Regras:
    - Deve ser possível armazenar diferentes tipos de dados (inteiros, strings, objetos personalizados).
    - Teste a classe com diferentes tipos e verifique se funciona corretamente.
Objetivo:
    Compreender o uso de classes genéricas e tipos parametrizados.
*/
package com.mycompany.caixagenerica;

// Classe principal onde o programa é executado
public class CaixaGenerica {

    // Método principal (ponto de entrada da aplicação)
    public static void main(String[] args) {

        /*
         * Cria uma instância da classe Caixa usando Integer como tipo genérico.
         * Isso significa que essa caixa só poderá armazenar valores do tipo Integer.
         */
        Caixa<Integer> caixaValores = new Caixa<>();
        caixaValores.setValue(10); // Armazena um número inteiro na caixa

        /*
         * Cria uma instância da classe Caixa usando String como tipo genérico.
         * Essa caixa só poderá armazenar textos (Strings).
         */
        Caixa<String> caixaDeNomes = new Caixa<>();
        caixaDeNomes.setValue("Olá, Mundo !"); // Armazena uma String na caixa

        // Exibe no console os valores armazenados em cada caixa
        System.out.println(caixaValores.getValue());
        System.out.println(caixaDeNomes.getValue());
    }
}
