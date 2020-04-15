package listas.atividade.estruturadedados.uam.linkedlist;

import java.util.ArrayList;

/**
 * @author NycolasVieira
 * @param <T>
 */
public interface ILinkedList<T> {
    
    public boolean isEmpty(Node node);
    
    public Node insertStart(T elem);
    
    public Node insertLast(T elem);
    
    public void removeStart();
    
    public void removeNode(T elem);
    
    public ArrayList<Node> getAllNodes();
    
    public Node getNode(T elem);
    
    public ArrayList<T> getAllValues();
    
    public T getValue(T elem);
    
    public String showList();
}
