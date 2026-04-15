// Pacote onde o programa está localizado
package com.mycompany.gerenciadoremails;

// Importa a classe HashSet para usar uma coleção que não permite elementos duplicados
import java.util.HashSet;

public class GerenciadorEmails {

    public static void main(String[] args) {
        // Cria um HashSet para armazenar e-mails únicos
        HashSet<String> emails = new HashSet();

        // Cadastra vários e-mails (alguns são duplicados propositalmente)
        cadastrarEmail(emails, "Ana@email.com");
        cadastrarEmail(emails, "Bruno@email.com");
        cadastrarEmail(emails, "Carla@email.com");
        cadastrarEmail(emails, "Diego@email.com");
        cadastrarEmail(emails, "Elisa@email.com");
        cadastrarEmail(emails, "Ana@email.com");     // Duplicado
        cadastrarEmail(emails, "Bruno@email.com");   // Duplicado

        // Lista todos os e-mails cadastrados
        listarEmails(emails);

        // Verifica se o e-mail da Carla está cadastrado
        contemEmail(emails, "Carla@email.com");

        // Remove o e-mail da Carla
        removerEmail(emails, "Carla@email.com");

        // Cadastra novamente o e-mail da Carla
        cadastrarEmail(emails, "Carla@email.com");
    }

    // Método para cadastrar um novo e-mail
    public static void cadastrarEmail(HashSet<String> emailLista, String email) {
        try {
            // Verifica se o e-mail é nulo ou vazio
            if (email == null || email.isBlank()) {
                throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
            } // Tenta adicionar o e-mail à lista
            else if (emailLista.add(email)) {
                System.out.printf("Email %s cadastrado com sucesso\n", email);
            } // Se o e-mail já existe, entra neste bloco
            else {
                System.out.printf("Tamanho da lista: %d\n", emailLista.size());
                System.out.printf("Tentando adicionar %s novamente\n", email);
                System.out.printf("Email %s já existe, não cadastrado\n", email);
                System.out.printf("Tamanho da lista após tentativa: %d\n", emailLista.size());
            }
        } catch (IllegalArgumentException e) {
            // Captura exceção de argumento inválido
            System.out.println("Erro ao criar o email: " + e.getMessage());
        }
    }

    // Método para listar todos os e-mails cadastrados
    public static void listarEmails(HashSet<String> emailLista) {
        System.out.println("Emails cadastrados\n------------------");
        emailLista.forEach(n -> System.out.printf("- %s\n", n)); // Itera sobre a lista
        System.out.println("------------------");
    }

    // Método para verificar se um e-mail existe na lista
    public static void contemEmail(HashSet<String> emailLista, String email) {
        try {
            // Verifica se o e-mail é nulo ou vazio
            if (email == null || email.isBlank()) {
                throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
            } // Verifica se o e-mail está no conjunto
            else if (!emailLista.contains(email)) {
                System.out.println("Email não encontrado");
            } else {
                System.out.printf("Email %s encontrado\n", email);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao pesquisar o email: " + e.getMessage());
        }
    }

    // Método para remover um e-mail da lista
    public static void removerEmail(HashSet<String> emailLista, String email) {
        try {
            // Verifica se o e-mail é nulo ou vazio
            if (email == null || email.isBlank()) {
                throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
            } // Tenta remover o e-mail
            else if (emailLista.remove(email)) {
                System.out.printf("Email %s removido com sucesso\n", email);
                listarEmails(emailLista); // Lista atualizada após a remoção
            } else {
                System.out.println("Email não encontrado");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao deletar o email: " + e.getMessage());
        }
    }
}
