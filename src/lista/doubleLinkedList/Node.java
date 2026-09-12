package lista.doubleLinkedList;

public class Node {
    private Object value;
    private Node prev;
    private Node next;

    public Node() {
        value = null;
        prev = null;
        next = null;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
