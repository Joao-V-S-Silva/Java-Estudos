// Classe que representa uma tarefa com um título e um status de conclusão.
package com.mycompany.gerenciadortarefas;

public class Tarefas {

    // Atributos privados que definem o título da tarefa e se ela foi concluída
    private String titulo;
    private boolean concluido;

    // Construtor que inicializa a tarefa com o título informado e marca como não concluída por padrão
    public Tarefas(String titulo) {
        this.titulo = titulo;
        this.concluido = false;
    }

    // Getter para acessar o título da tarefa
    public String getTitulo() {
        return titulo;
    }

    // Setter para alterar o título da tarefa
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Getter para verificar se a tarefa está concluída
    public boolean isConcluido() {
        return concluido;
    }

    // Setter para definir se a tarefa foi concluída ou não
    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    // Sobrescreve o método toString para exibir a tarefa de forma legível
    @Override
    public String toString() {
        return String.format("Tarefa: título: '%s', concluído: %s", titulo, concluido);
    }
}
