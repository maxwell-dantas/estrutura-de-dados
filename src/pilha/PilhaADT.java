package pilha;

public interface PilhaADT {
    public void push(Object item);
    public Object pop();
    public Object top();
    public int size();
    public boolean isEmpty();
}