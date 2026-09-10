package vector.doubleLinkedList;

import vector.VectorADT;
import vector.VectorVazio;

public class VectorDoubleLL implements VectorADT {
    private Node header;
    private Node trailer;
    private int size_;

    public VectorDoubleLL() {
        header = new Node();
        trailer = new Node();
        size_ = 0;
    }

    public void exibir() {
        if (isEmpty()) {
            System.out.println("O vetor está vazio!");
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
    public Object elementAtRank(Integer r) {
        if (isEmpty()) {
            throw new VectorVazio("O vetor está vazio!");
        }

        if (r < 0 || r >= size_) {
            String err = (r < 0) ? "abaixo" : "acima";
            throw new IllegalArgumentException("O valor do índice está " + err + " do escopo!");
        }

        Node node = header.getNext();

        for (int i = 0; i < r; i++) {
            node = node.getNext();
        }

        return node.getValue();
    }

    @Override
    public Object replaceAtRank(Integer r, Object item) {
        return r;
    }

    @Override
    public void insertAtRank(Integer r, Object item) {
        if (r < 0 || r > size_) {
            String err = (r < 0) ? "abaixo" : "acima";
            throw new IllegalArgumentException("O valor do índice está " + err + " do escopo!");
        }

        Node node = new Node();
        node.setValue(item);

        if (header.getNext() == null) {
            header.setNext(node);
            trailer.setPrev(node);
            node.setPrev(header);
            node.setNext(trailer);
            size_++;
            return;
        }

        if (r == 0) {
            node.setPrev(header);
            node.setNext(header.getNext());
            header.getNext().setPrev(node);
            header.setNext(node);
            size_++;
            return;
        }

        Node currentNode = header.getNext();

        for (int i = 0; i < r; i++) {
            currentNode = currentNode.getNext();
        }

        node.setPrev(currentNode.getPrev());
        node.setNext(currentNode);
        node.getPrev().setNext(node);
        currentNode.setPrev(node);
        size_++;
    }

    @Override
    public Object removeAtRank(Integer r) {
        return r;
    }

    @Override
    public int size() {
        return size_;
    }

    @Override
    public boolean isEmpty() {
        return size_ == 0;
    }

}
