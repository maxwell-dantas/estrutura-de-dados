package sequence.array;

import sequence.SequenceADT;
import sequence.Position;
import sequence.exceptions.EmptySequenceException;
import sequence.exceptions.RankOutOfBoundsException;

public class ArraySequence implements SequenceADT {
    private ArrayPosition[] list;
    private int capacity;
    private int size;
    private int fatorCrescimento;

    public ArraySequence(int capacity, int fatorCrescimento) {
        setCapacity(capacity);
        setFatorCrescimento(fatorCrescimento);
        list = new ArrayPosition[capacity];
        size = 0;
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

        ArrayPosition[] newList = new ArrayPosition[capacity];

        for (int i = 0; i < size; i++) {
            newList[i] = list[i];
        }

        list = newList;
    }

    private void validateRank(int rank) {
        if (isEmpty()) {
            throw new EmptySequenceException("A sequência está vazia.");
        }
        if (rank < 0 || rank >= size) {
            String bounds = (rank < 0) ? "abaixo" : "acima";
            throw new RankOutOfBoundsException("O rank inserido está " + bounds + " do escopo.");
        }
    }

    private ArrayPosition validatePosition(Position position) {
        if (!(position instanceof ArrayPosition)) {
            throw new IllegalArgumentException("O parâmetro passado não é uma posição de Array válida.");
        }

        return (ArrayPosition) position;
    }

    public void exibir() {
        if (isEmpty()) {
            System.out.println("A sequência está vazia!");
        } else {
            System.out.print("| ");
            for (int i = 0; i < size; i++) {
                System.out.print(list[i].getElement() + " | ");
            }
            System.out.println();
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Position atRank(int rank) {
        validateRank(rank);
        return list[rank];
    }

    @Override
    public int rankOf(Position position) {
        ArrayPosition pos = validatePosition(position);
        return pos.getIndex();
    }

    @Override
    public Object elementAtRank(int rank) {
        return atRank(rank).getElement();
    }

    @Override
    public Object replaceAtRank(int rank, Object object) {
        ArrayPosition pos = (ArrayPosition) atRank(rank);
        Object toReplace = pos.getElement();
        pos.setElement(object);
        return toReplace;
    }

    @Override
    public void insertAtRank(int rank, Object object) {
        if (rank < 0 || rank > size) {
            String bounds = (rank < 0) ? "abaixo" : "acima";
            throw new RankOutOfBoundsException("O rank inserido está " + bounds + " do escopo.");
        }

        if (capacity == size) {
            resize("aumentar");
        }

        for (int i = size; i > rank; i--) {
            list[i] = list[i - 1];
            list[i].setIndex(i);
        }

        list[rank] = new ArrayPosition(object, rank);
        size++;
    }

    @Override
    public Object removeAtRank(int rank) {
        validateRank(rank);
        ArrayPosition pos = list[rank];
        Object toRemove = pos.getElement();

        for (int i = rank; i < size - 1; i++) {
            list[i] = list[i + 1];
            list[i].setIndex(i);
        }

        size--;
        list[size] = null;

        if (size <= capacity / 4 && size > 1) {
            resize("reduzir");
        }

        return toRemove;
    }

    @Override
    public Object first() {
        if (isEmpty()) throw new EmptySequenceException("A sequência está vazia.");
        return list[0].getElement();
    }

    @Override
    public Object last() {
        if (isEmpty()) throw new EmptySequenceException("A sequência está vazia.");
        return list[size - 1].getElement();
    }

    @Override
    public Object before(Position position) {
        ArrayPosition pos = validatePosition(position);
        int idx = pos.getIndex();

        if (idx == 0) {
            throw new RankOutOfBoundsException("Não há elementos antes do selecionado.");
        }
        return list[idx - 1].getElement();
    }

    @Override
    public Object after(Position position) {
        ArrayPosition pos = validatePosition(position);
        int idx = pos.getIndex();

        if (idx == size - 1) {
            throw new RankOutOfBoundsException("Não há elementos depois do selecionado.");
        }
        return list[idx + 1].getElement();
    }

    @Override
    public Object replaceElement(Position position, Object object) {
        ArrayPosition pos = validatePosition(position);
        Object toReplace = pos.getElement();
        pos.setElement(object);
        return toReplace;
    }

    @Override
    public Object remove(Position position) {
        ArrayPosition pos = validatePosition(position);
        return removeAtRank(pos.getIndex());
    }

    @Override
    public void swapElement(Position position1, Position position2) {
        ArrayPosition pos1 = validatePosition(position1);
        ArrayPosition pos2 = validatePosition(position2);

        Object temp = pos1.getElement();
        pos1.setElement(pos2.getElement());
        pos2.setElement(temp);
    }

    @Override
    public void insertBefore(Position position, Object object) {
        ArrayPosition pos = validatePosition(position);
        insertAtRank(pos.getIndex(), object);
    }

    @Override
    public void insertAfter(Position position, Object object) {
        ArrayPosition pos = validatePosition(position);
        insertAtRank(pos.getIndex() + 1, object);
    }

    @Override
    public void insertFirst(Object object) {
        insertAtRank(0, object);
    }

    @Override
    public void insertLast(Object object) {
        insertAtRank(size, object);
    }
}