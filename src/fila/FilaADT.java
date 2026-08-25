package fila;

public interface FilaADT {
    public void enqueue(Object item);
    Object dequeue();
    public Object first();
    public int size();
    public boolean isEmpty();
}