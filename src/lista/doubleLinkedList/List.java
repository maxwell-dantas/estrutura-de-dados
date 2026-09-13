package lista.doubleLinkedList;

import lista.ListADT;
import lista.ListaVazia;
import lista.NoNaoEncontrado;
import lista.PosicaoInvalida;

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

        if (trailer.getPrev().getValue().equals(o)) {
            return trailer.getPrev();
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
        return n == header.getNext();
    }

    @Override
    public boolean isLast(Node n) {
        return n == trailer.getPrev();
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
            throw new PosicaoInvalida("Não há elementos antes do nó selecionado.");
        }
        return n.getPrev().getValue();
    }

    @Override
    public Object after(Node n) {
        if (n.getNext() == trailer) {
            throw new PosicaoInvalida("Não há elementos depois do nó selecionado.");
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
        Object temp = n.getValue();
        n.setValue(q.getValue());
        q.setValue(temp);
    }

    @Override
    public void insertBefore(Node n, Object o) {
        Node newNode = new Node();
        newNode.setValue(o);

        newNode.setPrev(n.getPrev());
        newNode.setNext(n);

        n.getPrev().setNext(newNode);
        n.setPrev(newNode);

        size_++;
    }

    @Override
    public void insertAfter(Node n, Object o) {
        Node newNode = new Node();
        newNode.setValue(o);

        newNode.setNext(n.getNext());
        newNode.setPrev(n);

        n.getNext().setPrev(newNode);
        n.setNext(newNode);

        size_++;
    }

    @Override
    public void insertFirst(Object o) {
        insertBefore(header.getNext(), o);
    }

    @Override
    public void insertLast(Object o) {
        insertAfter(trailer.getPrev(), o);
    }

    @Override
    public Object remove(Node n) {
        n.getPrev().setNext(n.getNext());
        n.getNext().setPrev(n.getPrev());
        n.setPrev(null);
        n.setNext(null);
        size_--;
        return n.getValue();
    }
}