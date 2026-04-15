package com.mycompany.sistemadevotacao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SistemaDeVotacao {

    public static void main(String[] args) {
        // Cria um mapa onde a chave é o número do candidato e o valor é o objeto Candidato
        Map<Integer, Candidato> candidatos = new HashMap<>();

        // Adiciona candidatos ao mapa (somente maiores de 18 anos são aceitos)
        adicionarCandidato(candidatos, "João", 23, 51);
        adicionarCandidato(candidatos, "Mariana", 21, 11);
        adicionarCandidato(candidatos, "Pedro", 45, 21);
        adicionarCandidato(candidatos, "Joaquim", 15, 10); // menor de idade, será rejeitado
        adicionarCandidato(candidatos, "Maria", 29, 33);
        adicionarCandidato(candidatos, "Helena", 32, 87);

        // Votos recebidos por número do candidato
        receberVoto(candidatos, 51);
        receberVoto(candidatos, 51);
        receberVoto(candidatos, 33);
        receberVoto(candidatos, 33);
        receberVoto(candidatos, 87);
        receberVoto(candidatos, 87);

        // Exibe todos os candidatos cadastrados
        listarCandidatos(candidatos);

        // Exibe a quantidade de votos de cada candidato
        listarVotos(candidatos);

        // Verifica qual candidato venceu (ou se houve empate)
        verificarVencedor(candidatos);
    }

    // Método para adicionar candidatos ao mapa
    public static void adicionarCandidato(Map<Integer, Candidato> candidatos, String nome, int idade, int numero) {
        System.out.println("---------- Tentando adicionar um novo candidato ----------");
        try {
            if (idade < 18) {
                // Gera erro se o candidato for menor de idade
                throw new IllegalArgumentException("Para se candidatar, precisa ter ao menos 18 anos");
            } else if (candidatos.containsKey(numero)) {
                // Gera erro se o número já estiver sendo usado por outro candidato
                throw new IllegalArgumentException("O número digitado já existe em outro candidato");
            } else {
                // Adiciona o candidato ao mapa
                candidatos.put(numero, new Candidato(nome, idade, numero));
                System.out.printf("Candidato %s adicionado com sucesso\n", nome);
            }
        } catch (IllegalArgumentException e) {
            // Exibe mensagem de erro amigável
            System.err.println("Ocorreu um erro: " + e.getMessage());
        }
    }

    // Método para registrar um voto a um candidato
    public static void receberVoto(Map<Integer, Candidato> candidatos, int numero) {
        System.out.println("---------- Tentando receber um voto ----------");
        Candidato candidato = candidatos.get(numero);
        if (candidato != null) {
            // Voto é contabilizado se o candidato for encontrado
            candidato.receberVoto();
            System.out.printf("Candidato %s com número %d encontrado, voto contabilizado!\n", candidato.getNome(), numero);
        } else {
            // Se não existir candidato com o número, avisa o usuário
            System.out.printf("Candidato com número %d não encontrado\n", numero);
        }
    }

    // Lista todos os candidatos cadastrados
    public static void listarCandidatos(Map<Integer, Candidato> candidatos) {
        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato cadastrado, verifique");
        } else {
            System.out.println("---------- Listando Candidatos ----------");
            for (Map.Entry<Integer, Candidato> entry : candidatos.entrySet()) {
                System.out.printf("Candidato: %s, Número: %d\n", entry.getValue().getNome(), entry.getKey());
            }
        }
    }

    // Lista a quantidade de votos de cada candidato
    public static void listarVotos(Map<Integer, Candidato> candidatos) {
        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato cadastrado, verifique");
        } else {
            System.out.println("---------- Listando votos dos candidatos ----------");
            for (Map.Entry<Integer, Candidato> entry : candidatos.entrySet()) {
                System.out.printf("Candidato: %s, votos: %d\n", entry.getValue().getNome(), entry.getValue().getTotalVotos());
            }
        }
    }

    // Verifica o vencedor da votação ou se houve empate
    public static void verificarVencedor(Map<Integer, Candidato> candidatos) {
        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato cadastrado, verifique");
        } else {
            System.out.println("---------- Analisando vencedor ----------");

            Candidato candidato = null;
            HashSet<Candidato> candidatosEmpatados = new HashSet<>();
            int maiorVoto = 0, totalVotos = 0;
            boolean empate = false;

            // Laço para identificar o maior número de votos e contar o total geral
            for (Map.Entry<Integer, Candidato> entry : candidatos.entrySet()) {
                totalVotos += entry.getValue().getTotalVotos();

                if (entry.getValue().getTotalVotos() > maiorVoto) {
                    // Novo líder, limpa os empatados anteriores
                    candidato = candidatos.get(entry.getKey());
                    maiorVoto = entry.getValue().getTotalVotos();
                } else if (candidato != null && entry.getValue().getTotalVotos() == candidato.getTotalVotos()) {
                    // Se houver empate, adiciona os dois candidatos ao conjunto
                    candidatosEmpatados.add(candidato);
                    candidatosEmpatados.add(entry.getValue());
                    empate = true;
                }
            }

            // Exibe o resultado: empate ou vencedor
            if (empate) {
                System.out.println("A votação empatou com os seguintes candidatos:");
                for (Candidato candidatosEmpatado : candidatosEmpatados) {
                    System.out.println(candidatosEmpatado);
                }
            } else {
                System.out.printf(
                        "O vencedor da votação foi %s com %d votos, representando %d%% dos votos\n",
                        candidato.getNome(),
                        candidato.getTotalVotos(),
                        (candidato.getTotalVotos() * 100) / totalVotos
                );
            }
        }
    }
}
