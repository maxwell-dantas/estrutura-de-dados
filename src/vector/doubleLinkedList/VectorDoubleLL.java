package vector.doubleLinkedList;

import vector.VectorVazio;

public class VectorDoubleLL implements VectorListADT {
    private Node head;
    private Node tail;
    private int size_;

    public VectorDoubleLL() {
        head = new Node();
        tail = new Node();
        size_ = 0;
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
    public Node first() {
        if (isEmpty()) {
            throw new VectorVazio("A lista está vazia!");
        }

        return head.getNext();
    }

    @Override
    public Node last() {
        if (isEmpty()) {
            throw new VectorVazio("A lista está vazia!");
        }

        return tail.getPrev();
    }

    @Override
    public Node before(Node n) {
        if (isEmpty()) {
            throw new VectorVazio("A lista está vazia!");
        }

        return n.getPrev();
    }

    @Override
    public Node after(Node n) {
        if (isEmpty()) {
            throw new VectorVazio("A lista está vazia!");
        }

        return n.getNext();
    }

    @Override
    public boolean isFirst(Node n) {
        return n == first();
    }

    @Override
    public boolean isLast(Node n) {
        return n == last();
    }

    @Override
    public void replaceElement(Node n, Object o) {
        if (isEmpty()) {
            throw new VectorVazio("A lista está vazia!");
        }

        n.setValue(o);
    }

    @Override
    public void swapElement(Node n, Node q) {
        if (isEmpty()) {
            throw new VectorVazio("A lista está vazia!");
        }

        n.getPrev().setNext(q);
        q.getNext().setPrev(n);
        q.setPrev(n.getPrev());
        n.setNext(q.getNext());

        q.setNext(n);
        n.setPrev(q);

    }

    @Override
    public Node insertBefore(Node n, Object o) {

    }

    @Override
    public Node insertAfter(Node n, Object o) {

    }

    @Override
    public Node insertFirst(Object o) {

    }

    @Override
    public Node insertLast(Object o) {

    }

    @Override
    public Node remove(Node n) {

    }
}
