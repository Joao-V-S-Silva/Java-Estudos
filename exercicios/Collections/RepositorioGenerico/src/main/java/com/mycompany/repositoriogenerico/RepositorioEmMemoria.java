// Define o pacote onde a classe está localizada
package com.mycompany.repositoriogenerico;

// Importações necessárias para uso de Map e HashMap
import java.util.HashMap;
import java.util.Map;

/**
 * Implementação em memória da interface RespositorioDeDados.
 *
 * <K> representa o tipo da chave (ID).
 * <V> representa o tipo do valor armazenado.
 *
 * Esta classe utiliza um HashMap para armazenar os dados em memória.
 */
public class RepositorioEmMemoria<K, V> implements RespositorioDeDados<K, V> {

    /**
     * Mapa responsável por armazenar os dados. K → chave (ID) V → valor
     */
    private Map<K, V> dados = new HashMap<>();

    /**
     * Salva um valor no repositório. Utiliza putIfAbsent para evitar
     * sobrescrever um valor existente.
     *
     * @param id identificador do dado
     * @param nome valor a ser armazenado
     */
    @Override
    public void salvar(K id, V nome) {
        dados.putIfAbsent(id, nome);
    }

    /**
     * Busca um valor no repositório a partir do ID.
     *
     * @param id identificador do dado
     * @return valor associado ao ID ou null se não existir
     */
    @Override
    public V buscar(K id) {
        return dados.get(id);
    }

    /**
     * Remove um valor do repositório com base no ID.
     *
     * @param id identificador do dado
     * @return valor removido ou null se não existir
     */
    @Override
    public V remover(K id) {
        return dados.remove(id);
    }

    /**
     * Retorna todos os dados armazenados no repositório.
     *
     * @return String contendo todos os pares chave = valor
     */
    @Override
    public String buscarTodos() {
        StringBuilder sb = new StringBuilder();

        // Percorre todas as entradas do mapa
        for (Map.Entry<K, V> entry : dados.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();

            sb.append(key)
                    .append(" = ")
                    .append(value)
                    .append("\n");
        }

        return sb.toString();
    }
}
