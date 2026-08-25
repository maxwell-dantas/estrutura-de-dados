package fila.linkedList;

import fila.FilaADT;
import fila.FilaVazia;

public class FilaLinkedList implements FilaADT {
    private Node first;
    private Node last;
    private int size_;

    public FilaLinkedList() {
        this.first = null;
        this.last = null;
        this.size_ = 0;
    }

    @Override
    public void enqueue(Object item) {
        Node node = new Node(item);

        if (this.first == null) {
            this.first = node;
        } else {
            this.last.setNext(node);
        }

        this.last = node;
        this.size_++;
    }

    @Override
    public Object dequeue() {
        if (this.first == null) {
            throw new FilaVazia("A fila está vazia!");
        }

        Object itemRemovido = this.first.getItem();
        this.first = this.first.getNext();

        if (first == null) {
            this.last = null;
        }

        this.size_--;

        return itemRemovido;
    }

    @Override
    public Object first() {
        if (this.first == null) {
            throw new FilaVazia("A fila está vazia!");
        }

        return this.first.getItem();
    }

    @Override
    public int size() {
        return this.size_;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    public void exibir() {
        Node node = this.first;

        while (node != null) {
            System.out.println(node.getItem());
            node = node.getNext();
        }
    }
}