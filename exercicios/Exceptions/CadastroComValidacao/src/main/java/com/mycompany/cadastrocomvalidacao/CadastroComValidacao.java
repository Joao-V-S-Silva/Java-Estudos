/*
Enunciado:
Crie um programa que permita cadastrar pessoas com nome e idade. Se:
- o nome for vazio, lance uma exceção personalizada NomeVazioException
- a idade for menor que 0 ou maior que 150, lance uma exceção personalizada IdadeInvalidaException
 */
package com.mycompany.cadastrocomvalidacao;

import java.util.ArrayList;

public class CadastroComValidacao {

    static ArrayList<Pessoa> pessoas = new ArrayList<>();

    public static void main(String[] args) {
        cadastrarPessoa("", 0);
        cadastrarPessoa("Mariana", 20);
        cadastrarPessoa("Nicolas", 0);
        cadastrarPessoa("João Victor", 23);
        
        System.out.println(pessoas.toString());
    }

    public static void cadastrarPessoa(String nome, int idade) {

        try {
            if (nome.isEmpty()) {
                throw new NomeVazioException("O nome digitado está vazio, verifique !");
            } else if (idade < 0 || idade > 150) {
                throw new IdadeInvalidaException("A idade digitada é inválida, verifique !");
            } else {
                Pessoa pessoa = new Pessoa(nome, idade);
                pessoas.add(pessoa);
                System.out.printf("Cadastro de %s realizado com sucesso !\n", nome);
            }

        } catch (NomeVazioException | IdadeInvalidaException e) {
            System.err.println("Erro: " + e.getMessage());
        }

    }
}
