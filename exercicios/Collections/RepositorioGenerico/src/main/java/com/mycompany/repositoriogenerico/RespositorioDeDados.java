// Define o pacote onde a interface está localizada
package com.mycompany.repositoriogenerico;

/**
 * Interface genérica RepositorioDeDados.
 *
 * <K> representa o tipo da chave (ex: Integer, Long, String).
 * <V> representa o tipo do valor armazenado (ex: String, objeto personalizado).
 *
 * Essa interface define as operações básicas de um repositório de dados.
 */
public interface RespositorioDeDados<K, V> {

    /**
     * Salva um valor no repositório associado a um identificador.
     *
     * @param id identificador do dado (tipo K)
     * @param nome valor a ser armazenado (tipo V)
     */
    void salvar(K id, V nome);

    /**
     * Busca um valor no repositório a partir do identificador.
     *
     * @param id identificador do dado
     * @return valor associado ao id (tipo V)
     */
    V buscar(K id);

    /**
     * Remove um valor do repositório a partir do identificador.
     *
     * @param id identificador do dado
     * @return valor removido do repositório (tipo V)
     */
    V remover(K id);

    /**
     * Retorna todos os dados armazenados no repositório.
     *
     * @return String contendo a representação de todos os dados
     */
    String buscarTodos();
}
