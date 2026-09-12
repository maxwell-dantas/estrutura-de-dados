package lista;

import lista.doubleLinkedList.Node;

public interface ListADT {
    // métodos genéricos
    public int size();
    public boolean isEmpty();

    // métodos de fila
    public boolean isFirst(Node n);
    public boolean isLast(Node n);

    // métodos de acesso
    public Object first();
    public Object last();
    public Object before(Node n);
    public Object after(Node n);

    // métodos para atualizar
    public Object replaceElement(Node n, Object o);
    public void swapElement(Node n, Node q);
    public void insertBefore(Node n, Object o);
    public void insertAfter(Node n, Object o);
    public void insertFirst(Object o);
    public void insertLast(Object o);
    public Object remove(Node n);
}
