package pilha.linkedList;

public class Node {
    private Object item;
    private Node next;

    public Node(Object item) {
        this.item = item;
        this.next = null;
    }

    public Object getItem() {
        return this.item;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
