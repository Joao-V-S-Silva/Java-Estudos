/*
Enunciado:
1. Crie uma classe IdadeInvalidaException que herda de Exception.
2. Crie um método verificarIdade(int idade) que lança essa exceção se a idade for menor que 18.
3. No main, peça a idade ao usuário e trate a exceção, exibindo uma mensagem amigável.
 */
package com.mycompany.excecaopersonalizada;

public class ExcecaoPersonalizada {

    public static void main(String[] args) {
        VerificarIdade(17);
        VerificarIdade(19);
        VerificarIdade(25);
        VerificarIdade(8);
    }

    public static void VerificarIdade(int idade) {
        try {
            if (idade <= 17) {
                throw new IdadeInvalidaException("Menor de idade, acesso negado !");
            } else {
                System.out.println("Maior de idade, acesso liberado !");
            }
        } catch (IdadeInvalidaException e) {
            System.err.println(e.getMessage());
        }
    }
}
