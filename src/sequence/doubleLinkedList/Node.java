package sequence.doubleLinkedList;

import sequence.Position;

class Node implements Position {
    private Node next;
    private Node prev;
    private Object element;

    public Node() {
        next = null;
        prev = null;
        element = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }
}