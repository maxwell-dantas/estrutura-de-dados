package sequence.doubleLinkedList;

import sequence.SequenceADT;
import sequence.exceptions.EmptySequenceException;
import sequence.exceptions.IsNotNodeException;
import sequence.Position;
import sequence.exceptions.NodeNotFoundException;
import sequence.exceptions.RankOutOfBoundsException;

public class Sequence implements SequenceADT {
    private Node header;
    private Node trailer;
    private int size;

    public Sequence() {
        header = new Node();
        trailer = new Node();

        header.setNext(trailer);
        trailer.setPrev(header);

        size = 0;
    }

    private void validateRank(int rank) {
        if (isEmpty()) {
            throw new EmptySequenceException("A sequência está vazia.");
        }
        if (rank < 0 || rank >= size) {
            String bounds = (rank < 0) ? "abaixo" : "acima";
            throw new RankOutOfBoundsException("O rank inserido está " + bounds + " do escopo.");
        }
    }

    private Node validateNode(Position position) {
        if (!(position instanceof Node)) {
            throw new IsNotNodeException("O parâmetro passado não é um nó.");
        }

        return (Node) position;
    }

    public void exibir() {
        Node node = header.getNext();
        System.out.print("Header <-> ");
        while (node != trailer) {
            System.out.print(node.getElement() + " <-> ");
            node = node.getNext();
        }
        System.out.println("Trailer");
    }

    @Override
    public Position atRank(int rank) {
        validateRank(rank);

        Node node = header.getNext();
        for (int i = 0; i < rank; i++) {
            node = node.getNext();
        }

        return node;
    }

    @Override
    public int rankOf(Position position) {
        Node node = validateNode(position);

        Node currentNode = header.getNext();

        for (int i = 0; i < size; i++) {
            if (currentNode == node) {
                return i;
            }
            currentNode = currentNode.getNext();
        }

        throw new NodeNotFoundException("O nó não foi encontrado!");
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object elementAtRank(int rank) {
        return atRank(rank).getElement();
    }

    @Override
    public Object replaceAtRank(int rank, Object object) {
        Node node = (Node) atRank(rank);
        Object toReplace = node.getElement();
        node.setElement(object);
        return toReplace;
    }

    @Override
    public Object removeAtRank(int rank) {
        Node node = (Node) atRank(rank);
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        node.setPrev(null);
        node.setNext(null);
        size--;
        return node.getElement();
    }

    @Override
    public void insertAtRank(int rank, Object object) {
        if (rank < 0 || rank > size) {
            String bounds = (rank < 0) ? "abaixo" : "acima";
            throw new RankOutOfBoundsException("O rank inserido está " + bounds + " do escopo.");
        }

        Node node = header.getNext();

        for (int i = 0; i < rank; i++) {
            node = node.getNext();
        }

        Node newNode = new Node();
        newNode.setElement(object);

        newNode.setPrev(node.getPrev());
        newNode.setNext(node);

        node.getPrev().setNext(newNode);
        node.setPrev(newNode);

        size++;
    }

    @Override
    public Object first() {
        if (isEmpty()) {
            throw new EmptySequenceException("A sequência está vazia.");
        }
        return header.getNext().getElement();
    }

    @Override
    public Object last() {
        if (isEmpty()) {
            throw new EmptySequenceException("A sequência está vazia.");
        }
        return trailer.getPrev().getElement();
    }

    @Override
    public Object before(Position position) {
        Node node = validateNode(position);

        if (node.getPrev() == header) {
            throw new RankOutOfBoundsException("Não há elementos antes do elemento selecionado.");
        }
        return node.getPrev().getElement();
    }

    @Override
    public Object after(Position position) {
        Node node = validateNode(position);

        if (node.getNext() == trailer) {
            throw new RankOutOfBoundsException("Não há elementos depois do elemento selecionado.");
        }
        return node.getNext().getElement();
    }

    @Override
    public Object replaceElement(Position node, Object object) {
        Node nodeV = validateNode(node);
        Object toReplace = nodeV.getElement();
        nodeV.setElement(object);
        return toReplace;
    }

    @Override
    public Object remove(Position node) {
        Node nodeV = validateNode(node);
        nodeV.getPrev().setNext(nodeV.getNext());
        nodeV.getNext().setPrev(nodeV.getPrev());
        nodeV.setPrev(null);
        nodeV.setNext(null);
        size--;
        return nodeV.getElement();
    }

    @Override
    public void swapElement(Position node1, Position node2) {
        Node nodeV1 = validateNode(node1);
        Node nodeV2 = validateNode(node2);

        Object temp = nodeV1.getElement();
        nodeV1.setElement(nodeV2.getElement());
        nodeV2.setElement(temp);
    }

    @Override
    public void insertBefore(Position node, Object object) {
        Node nodeV = validateNode(node);
        Node newNode = new Node();
        newNode.setElement(object);

        newNode.setPrev(nodeV.getPrev());
        newNode.setNext(nodeV);

        nodeV.getPrev().setNext(newNode);
        nodeV.setPrev(newNode);

        size++;
    }

    @Override
    public void insertAfter(Position node, Object object) {
        Node nodeV = validateNode(node);
        Node newNode = new Node();
        newNode.setElement(object);

        newNode.setNext(nodeV.getNext());
        newNode.setPrev(nodeV);

        nodeV.getNext().setPrev(newNode);
        nodeV.setNext(newNode);

        size++;
    }

    @Override
    public void insertFirst(Object object) {
        insertAfter(header, object);
    }

    @Override
    public void insertLast(Object object) {
        insertBefore(trailer, object);
    }
}