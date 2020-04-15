package listas.atividade.estruturadedados.uam.linkedlist;

/**
 * @author NycolasVieira
 * @param <T>
 */
public class Node<T> {
    public Node next;
    public T value;

    public Node(T val) {
        value = val;
        next = null;
    }
}
