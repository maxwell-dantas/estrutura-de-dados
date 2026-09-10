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
        header.setNext(trailer);
        trailer.setPrev(header);
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
            throw new IndexOutOfBoundsException("O valor do índice está " + err + " do escopo!");
        }

        if (r == size_ - 1) {
            return trailer.getPrev().getValue();
        }

        Node node = header.getNext();

        for (int i = 0; i < r; i++) {
            node = node.getNext();
        }

        return node.getValue();
    }

    @Override
    public Object replaceAtRank(Integer r, Object item) {
        if (isEmpty()) {
            throw new VectorVazio("O vetor está vazio!");
        }

        if (r < 0 || r >= size_) {
            String err = (r < 0) ? "abaixo" : "acima";
            throw new IndexOutOfBoundsException("O valor do índice está " + err + " do escopo!");
        }

        if (r == size_ - 1) {
            Object toReplace = trailer.getPrev().getValue();
            trailer.getPrev().setValue(item);
            return toReplace;
        }

        Node toReplace = header.getNext();

        for (int i = 0; i < r; i++) {
            toReplace = toReplace.getNext();
        }

        Object toReplaceValue = toReplace.getValue();
        toReplace.setValue(item);

        return toReplaceValue;
    }

    @Override
    public void insertAtRank(Integer r, Object item) {
        if (r < 0 || r > size_) {
            String err = (r < 0) ? "abaixo" : "acima";
            throw new IndexOutOfBoundsException("O valor do índice está " + err + " do escopo!");
        }

        Node node = new Node();
        node.setValue(item);

        if (r == size_) {
            node.setNext(trailer);
            node.setPrev(trailer.getPrev());
            trailer.getPrev().setNext(node);
            trailer.setPrev(node);
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
        if (isEmpty()) {
            throw new VectorVazio("O vetor está vazio!");
        }

        if (r < 0 || r >= size_) {
            String err = (r < 0) ? "abaixo" : "acima";
            throw new IndexOutOfBoundsException("O valor do índice está " + err + " do escopo!");
        }

        if (r == size_ - 1) {
            Node toRemove = trailer.getPrev();
            toRemove.getPrev().setNext(toRemove.getNext());
            toRemove.getNext().setPrev(toRemove.getPrev());

            toRemove.setPrev(null);
            toRemove.setNext(null);
            size_--;
            return toRemove.getValue();
        }

        Node toRemove = header.getNext();

        for (int i = 0; i < r; i++) {
            toRemove = toRemove.getNext();
        }

        toRemove.getPrev().setNext(toRemove.getNext());
        toRemove.getNext().setPrev(toRemove.getPrev());

        toRemove.setPrev(null);
        toRemove.setNext(null);
        size_--;

        return toRemove.getValue();
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
