package com.mycompany.arraylistalunos;

import java.util.ArrayList;

public class ArrayListAlunos {

    private ArrayList<String> alunos = new ArrayList();

    public static void main(String[] args) {
        ArrayListAlunos gerenciador = new ArrayListAlunos();

        gerenciador.adicionarAluno("João");
        gerenciador.adicionarAluno("Maria");
        gerenciador.adicionarAluno("Pedro");
        gerenciador.adicionarAluno("Breno");
        gerenciador.adicionarAluno("Chatgpt");

        gerenciador.removerAluno(2);
        System.out.println(gerenciador.listarAlunos());
        System.out.println(gerenciador.alunoExiste("João"));
        System.out.println(gerenciador.tamanhoLista());
    }

    public String listarAlunos() {
        if (alunos.isEmpty()) {
            return "Nenhum aluno cadastrado, verifique";
        } else {
            return alunos.toString();
        }
    }

    public void adicionarAluno(String aluno) {
        try {
            if (aluno == null || aluno.isBlank()) {
                throw new IllegalArgumentException("O aluno não pode ser nulo ou vazio");
            } else {
                alunos.add(aluno);
                System.out.printf("Aluno %s adicionado com sucesso!\n", aluno);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar aluno: " + e.getMessage());
        }
    }

    public void removerAluno(int indice) {
        try {
            if (indice < 0 || indice >= alunos.size()) {
                throw new IllegalArgumentException("Indice incorreto, verifique!");
            } else {
                String alunoRemovido = alunos.get(indice);
                alunos.remove(indice);
                System.out.printf("Aluno %s removido com sucesso!\n", alunoRemovido);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao remover aluno: " + e.getMessage());
        }
    }

    public boolean alunoExiste(String aluno) {
        if (aluno != null && !aluno.isBlank() && alunos.contains(aluno)) {
            System.out.printf("Aluno %s encontrado e existe na lista\n", aluno);
            return alunos.contains(aluno);
        } else {
            System.out.println("Aluno inválido, verifique");
            return false;
        }
    }

    public String tamanhoLista() {
        return "O tamanho atual da lista é: " + alunos.size();
    }
}
