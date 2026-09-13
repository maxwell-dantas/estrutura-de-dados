package lista.array;

import lista.ListADT;
import lista.ListaVazia;
import lista.NoNaoEncontrado;
import lista.PosicaoInvalida;
import lista.doubleLinkedList.Node;

public class ListArray implements ListADT {
    private Node[] list;
    private int capacity;
    private int size_;
    private int fatorCrescimento;

    public ListArray(int capacity, int fatorCrescimento) {
        setCapacity(capacity);
        setFatorCrescimento(fatorCrescimento);
        list = new Node[capacity];
        size_ = 0;
    }

    private void setCapacity(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("A capacidade mínima inicial deve ser maior que 0.");
        }
        this.capacity = capacity;
    }

    private void setFatorCrescimento(int fatorCrescimento) {
        if (fatorCrescimento < 0) {
            throw new IllegalArgumentException("O fator de crescimento deve ser um número natural.");
        }

        this.fatorCrescimento = fatorCrescimento;
    }

    private void insert(int idx, Object o) {
        if (capacity == size_) {
            resize("aumentar");
        }

        Node newNode = new Node();
        newNode.setValue(o);

        for (int i = size_; i > idx; i--) {
            list[i] = list[i-1];
        }

        list[idx] = newNode;
        size_++;
    }

    private void resize(String selector) {
        if (selector.equals("aumentar")) {
            if (fatorCrescimento == 0) {
                capacity *= 2;
            } else {
                capacity += fatorCrescimento;
            }

        } else if (selector.equals("reduzir")) {
            capacity /= 2;
        }

        Node[] newList = new Node[capacity];

        for (int i = 0; i < size_; i++) {
            newList[i] = list[i];
        }

        list = newList;
    }

    public void exibir() {
        if (isEmpty()) {
            System.out.println("a lista está vazia!");
        } else {
            System.out.print("| ");
            for (int i = 0; i < size_; i++) {
                System.out.print(list[i].getValue() + " | ");
            }
        }
    }

    public Node search(int indice) {
        if (isEmpty()) {
            throw new ListaVazia("A lista está vazia!");
        }

        if (indice < 0 || indice >= size_) {
            String err = (indice < 0) ? "abaixo" : "acima";
            throw new IndexOutOfBoundsException("O valor do índice está " + err + " do escopo!");
        }

        return list[indice];
    }

    public int nodeIndice(Node n) {
        if (isEmpty()) {
            throw new ListaVazia("A lista está vazia!");
        }

        for (int i = 0; i < size_; i++) {
            if (list[i] == n) {
                return i;
            }
        }

        throw new NoNaoEncontrado("O nó não foi encontrado na lista.");
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
    public boolean isFirst(Node n) {
        return n == list[0];
    }

    @Override
    public boolean isLast(Node n) {
        return n == list[size_-1];
    }

    @Override
    public Object first() {
        if (isEmpty()) {
            throw new ListaVazia("A lista está vazia!");
        }

        return list[0].getValue();
    }

    @Override
    public Object last() {
        if (isEmpty()) {
            throw new ListaVazia("A lista está vazia!");
        }
        return list[size_-1].getValue();
    }

    @Override
    public Object before(Node n) {
        int idxNode = nodeIndice(n);

        if (idxNode == 0) {
            throw new PosicaoInvalida("Não há elementos antes do nó selecionado.");
        }

        return list[idxNode - 1].getValue();
    }

    @Override
    public Object after(Node n) {
        int idxNode = nodeIndice(n);

        if (idxNode == size_ - 1) {
            throw new PosicaoInvalida("Não há elementos depois do nó selecionado.");
        }

        return list[idxNode + 1].getValue();
    }

    @Override
    public Object replaceElement(Node n, Object o) {
        Object toReplace = list[nodeIndice(n)].getValue();
        n.setValue(o);
        return toReplace;
    }

    @Override
    public void swapElement(Node n, Node q) {
        Object temp = n.getValue();
        n.setValue(q.getValue());
        q.setValue(temp);
    }

    @Override
    public void insertBefore(Node n, Object o) {
        insert(nodeIndice(n), o);
    }

    @Override
    public void insertAfter(Node n, Object o) {
        insert(nodeIndice(n) + 1, o);
    }

    @Override
    public void insertFirst(Object o) {
        insert(0, o);
    }

    @Override
    public void insertLast(Object o) {
        insert(size_, o);
    }

    @Override
    public Object remove(Node n) {
        Object toRemove = n.getValue();

        for (int i = nodeIndice(n); i < size_ - 1; i++) {
            list[i] = list[i + 1];
        }

        size_--;
        list[size_] = null;

        if (size_ <= capacity / 4 && size_ > 1) {
            resize("reduzir");
        }

        return toRemove;
    }
}
