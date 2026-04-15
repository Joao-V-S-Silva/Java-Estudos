// Declara o pacote onde a classe está localizada
package com.mycompany.caixagenerica;

/**
 * Classe genérica Caixa.
 *
 * <T> representa um tipo genérico, que será definido no momento em que a classe
 * for instanciada. Exemplo: Caixa<String>, Caixa<Integer>, etc.
 */
public class Caixa<T> {

    // Atributo genérico que armazenará um valor do tipo T
    private T value;

    /**
     * Método getter.
     *
     * Retorna o valor armazenado na caixa.
     *
     * @return valor do tipo T
     */
    public T getValue() {
        return value;
    }

    /**
     * Método setter.
     *
     * Define o valor a ser armazenado na caixa.
     *
     * @param value valor do tipo T que será armazenado
     */
    public void setValue(T value) {
        this.value = value;
    }
}
