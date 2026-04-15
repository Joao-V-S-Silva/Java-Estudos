package com.mycompany.arraylistalunos;

import java.util.ArrayList;

/**
 * Classe principal que demonstra o uso do ArrayList do Java Collections
 * para gerenciar uma lista de nomes de alunos.
 * 
 * Realiza operações básicas como adicionar, remover, listar, verificar existência
 * e obter tamanho da lista, com validações de entrada.
 * 
 * @author Desenvolvedor
 * @version 1.0
 */
public class ArrayListAlunos {

    private ArrayList<String> alunos = new ArrayList<>();

    /**
     * Método principal que demonstra o uso da classe.
     * Cria uma instância, adiciona alunos, remove um, lista, verifica existência e mostra tamanho.
     * 
     * @param args argumentos de linha de comando (não utilizados)
     */
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

    /**
     * Lista todos os alunos cadastrados.
     * 
     * @return String com representação da lista ou mensagem se vazia.
     */
    public String listarAlunos() {
        if (alunos.isEmpty()) {
            return "Nenhum aluno cadastrado, verifique";
        } else {
            return alunos.toString();
        }
    }

    /**
     * Adiciona um aluno à lista.
     * 
     * @param aluno nome do aluno a adicionar (não pode ser nulo ou vazio)
     * @throws IllegalArgumentException se o nome for inválido
     */
    public void adicionarAluno(String aluno) {
        try {
            // Validação: verifica se o nome do aluno é válido (não nulo e não vazio)
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

    /**
     * Remove um aluno da lista pelo índice.
     * 
     * @param indice posição do aluno na lista (0-based)
     * @throws IllegalArgumentException se índice inválido
     */
    public void removerAluno(int indice) {
        try {
            // Validação: verifica se o índice está dentro dos limites da lista
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

    /**
     * Verifica se um aluno existe na lista.
     * 
     * @param aluno nome do aluno a buscar
     * @return true se encontrado e válido, false caso contrário
     */
    public boolean alunoExiste(String aluno) {
        if (aluno != null && !aluno.isBlank() && alunos.contains(aluno)) {
            System.out.printf("Aluno %s encontrado e existe na lista\n", aluno);
            return alunos.contains(aluno);
        } else {
            System.out.println("Aluno inválido, verifique");
            return false;
        }
    }

    /**
     * Retorna o tamanho atual da lista de alunos.
     * 
     * @return String com o número de alunos cadastrados
     */
    public String tamanhoLista() {
        return "O tamanho atual da lista é: " + alunos.size();
    }
}
