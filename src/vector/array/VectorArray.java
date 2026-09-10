package vector.array;

import vector.VectorADT;
import vector.VectorVazio;

public class VectorArray implements VectorADT {
    private Object[] vector;
    private int capacity;
    private int size_;
    private int fatorCrescimento;

    public VectorArray(int capacity, int fatorCrescimento) {
        setCapacity(capacity);
        setFatorCrescimento(fatorCrescimento);
        vector = new Object[this.capacity];
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

    private void resize(int selector) {
        if (selector == 0) {
            this.capacity /= 2;
        } else if (selector == 1) {
            if (fatorCrescimento == 0) {
                capacity *= 2;
            } else {
                capacity += fatorCrescimento;
            }
        }

        Object[] newVector = new Object[capacity];

        for (int i = 0; i < size(); i++) {
            newVector[i] = vector[i];
        }

        vector = newVector;
    }

    public void exibir() {
        if (isEmpty()) {
            System.out.println("O vetor está vazio!");
        } else {
            System.out.print("| ");
            for (int i = 0; i < size_; i++) {
                System.out.print(vector[i] + " | ");
            }
            System.out.println();
        }
    }

    @Override
    public Object elementAtRank(Integer r) {
        if (isEmpty()) {
            throw new VectorVazio("O vetor está vazio!");
        }

        if (r < 0 || r >= size_) {
            String err = (r < 0) ? "abaixo" : "acima";
            throw new IllegalArgumentException("O valor do índice está " + err + " do escopo!");
        }

        return vector[r];
    }

    @Override
    public Object replaceAtRank(Integer r, Object item) {
        if (isEmpty()) {
            throw new VectorVazio("O vetor está vazio!");
        }

        if (r < 0 || r >= size_) {
            String err = (r < 0) ? "abaixo" : "acima";
            throw new IllegalArgumentException("O valor do índice está " + err + " do escopo!");
        }

        Object itemRemovido = vector[r];
        vector[r] = item;
        return itemRemovido;
    }

    @Override
    public void insertAtRank(Integer r, Object item) {
        if (size_ == capacity) {
            resize(1);
        }

        if (r < 0 || r > size_) {
            String err = (r < 0) ? "abaixo" : "acima";
            throw new IllegalArgumentException("O valor do índice está " + err + " do escopo!");
        }

        for (int i = size_; i > r; i--) {
            vector[i] = vector[i - 1];
        }

        vector[r] = item;
        size_++;
    }

    @Override
    public Object removeAtRank(Integer r) {
        if (isEmpty()) {
            throw new VectorVazio("O vetor está vazio!");
        }

        if (r < 0 || r >= size_) {
            String err = (r < 0) ? "abaixo" : "acima";
            throw new IllegalArgumentException("O valor do índice está " + err + " do escopo!");
        }

        if (size_ <= capacity / 2 && size_ > 1) {
            resize(0);
        }

        Object itemRemovido = vector[r];

        for (int i = r; i < size_ - 1; i++) {
            vector[i] = vector[i + 1];
        }

        size_--;
        vector[size_] = null; // remove a referência ao objeto. ex.: [1, 2, 3] --> [1, 2, null]
        return itemRemovido;
    }

    @Override
    public int size() {
        return size_;
    }

    @Override
    public boolean isEmpty() {
        return size_ == 0;
    }
}