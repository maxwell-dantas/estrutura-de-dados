package pilha.pilhaLinkedList;

import pilha.*;

public class PilhaLinkedList implements PilhaADT{
    private Node topo;
    private int size_;

    public PilhaLinkedList() {
        this.topo = null;
        this.size_ = 0;
    }

    @Override
    public void push(Object item) {
        Node node = new Node(item);
        node.setNext(this.topo);
        this.topo = node;
        this.size_++;
    }

    @Override
    public Object pop() {
        if (this.isEmpty()) {
            throw new PilhaVazia("A pilha está vazia!");
        }

        Object itemRemovido = this.topo.getItem();
        this.topo = this.topo.getNext();
        this.size_--;
        return itemRemovido;
    }

    @Override
    public Object top() {
        if (this.isEmpty()) {
            throw new PilhaVazia("A pilha está vazia!");
        }
        return this.topo.getItem();
    }

    @Override
    public int size() {
        return this.size_;
    }

    @Override
    public boolean isEmpty() {
        return this.topo == null;
    }
}