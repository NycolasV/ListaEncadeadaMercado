package listas.atividade.estruturadedados.uam.linkedlist;

import java.util.ArrayList;

/**
 * @author NycolasVieira
 * @param <T>
 */
public class LinkedList<T> implements ILinkedList<T>{

    private Node start;

    @Override
    public boolean isEmpty(Node node) {
        return node == null;
    }

    @Override
    public Node insertStart(T elem) {
        Node newNode = new Node(elem);
        newNode.next = start;
        start = newNode;
        
        return newNode;
    }

    @Override
    public Node insertLast(T elem) {
        for (var node = start; node != null; node = node.next) {
            if(node.next == null){
                Node newNode = new Node(elem);
                node.next = newNode;
                return newNode;
            }
        }

        return null;
    }

    @Override
    public void removeStart() {
        start = start.next;
    }

    @Override
    public void removeNode(T elem) {
        if(elem == start.value)
            removeStart();
            
        var before = start;
        for (var node = start; node != null; node = node.next) {
            if(node.value == elem){
                before.next = node.next;
                node.value = null;
                node.next = null;
                break;
            }
            
            before = node;
        }
    }

    @Override
    public ArrayList<Node> getAllNodes() {
        var list = new ArrayList<Node>();
        for (var node = start; node != null; node = node.next) {
            list.add(node);
        }

        return list;
    }

    @Override
    public Node getNode(T elem) {
        for (var node = start; node != null; node = node.next) {
            if (elem == node.value) {
                return node;
            }
        }

        return null;
    }

    @Override
    public ArrayList<T> getAllValues() {
        var list = new ArrayList<T>();
        for (var node = start; node != null; node = node.next) {
            list.add((T)node.value);
        }

        return list;
    }
    
    @Override
    public T getValue(T elem) {
        for (var node = start; node != null; node = node.next) {
            if (elem == node.value) {
                return (T)node.value;
            }
        }

        return null;
    }

    @Override
    public String showList() {
        if (isEmpty(this.start)) {
            return "Lista vazia\n";
        }

        String list = "";
        for (var node = start; node != null; node = node.next) {
            list += " " + node.value;
        }
        
        return list + "\n";
    }
}
