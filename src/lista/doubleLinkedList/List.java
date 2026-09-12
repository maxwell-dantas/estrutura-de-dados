package lista.doubleLinkedList;

import lista.ListADT;
import lista.ListaVazia;
import lista.NoNaoEncontrado;

public class List implements ListADT {
    private Node header;
    private Node trailer;
    private int size_;

    public List() {
        header = new Node();
        trailer = new Node();
        size_ = 0;

        header.setNext(trailer);
        trailer.setPrev(header);
    }

    public Node search(Object o) {
        if (isEmpty()) {
            throw new ListaVazia("A lista está vazia!");
        }

        Node currentNode = header.getNext();

        while (currentNode != trailer) {
            if (currentNode.getValue().equals(o)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }

        throw new NoNaoEncontrado("O objeto não foi encontrado na lista.");
    }

    public void exibir() {
        if (isEmpty()) {
            System.out.println("A lista está vazia!");
        } else {
            Node node = header.getNext();

            System.out.print("Header <-> ");
            while (node != trailer) {
                System.out.print(node.getValue() + " <-> ");
                node = node.getNext();
            }
            System.out.print("Trailer");
        }
    }

    @Override
    public int size() {
        return size_;
    }

    @Override
    public boolean isEmpty() {
        return size_ == 0;
    }

    @Override
    public boolean isFirst(Node n) {
        return n.getValue() == first();
    }

    @Override
    public boolean isLast(Node n) {
        return n.getValue() == last();
    }

    @Override
    public Object first() {
        if (isEmpty()) {
            throw new ListaVazia("A lista está vazia!");
        }
        return header.getNext().getValue();
    }

    @Override
    public Object last() {
        if (isEmpty()) {
            throw new ListaVazia("A lista está vazia!");
        }
        return trailer.getPrev().getValue();
    }

    @Override
    public Object before(Node n) {
        if (n.getPrev() == header) {
            throw new OutOfMemoryError("Não há elementos antes do nó selecionado.");
        }
        return n.getPrev().getValue();
    }

    @Override
    public Object after(Node n) {
        if (n.getNext() == trailer) {
            throw new OutOfMemoryError("Não há elementos depois do nó selecionado.");
        }
        return n.getNext().getValue();
    }

    @Override
    public Object replaceElement(Node n, Object o) {
        Object toReplace = n.getValue();
        n.setValue(o);
        return toReplace;
    }

    @Override
    public void swapElement(Node n, Node q) {

    }

    @Override
    public void insertBefore(Node n, Object o) {

    }

    @Override
    public void insertAfter(Node n, Object o) {

    }

    @Override
    public void insertFirst(Object o) {
        Node newNode = new Node();
        newNode.setValue(o);

        newNode.setPrev(header);
        newNode.setNext(header.getNext());

        header.getNext().setPrev(newNode);
        header.setNext(newNode);

        size_++;
    }

    @Override
    public void insertLast(Object o) {
        Node newNode = new Node();
        newNode.setValue(o);

        newNode.setPrev(trailer.getPrev());
        newNode.setNext(trailer);

        trailer.getPrev().setNext(newNode);
        trailer.setPrev(newNode);

        size_++;
    }

    @Override
    public Object remove(Node n) {
        return n.getValue();
    }
}