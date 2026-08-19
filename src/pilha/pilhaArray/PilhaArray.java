package pilha.pilhaArray;

import pilha.*;

public class PilhaArray implements PilhaADT {
    private int topo;
    private int capacidade;
    private int fatorCrescimento;
    private Object[] items;

    public PilhaArray(int capacidade, int fatorCrescimento) {
        this.topo = -1;
        this.setCapacidade(capacidade);
        this.setFatorCrescimento(fatorCrescimento);
        items = new Object[this.capacidade];
    }

    public int getCapacidade() {
        return this.capacidade;
    }

    private void setCapacidade(int capacidade) {
        if (capacidade < 1) {
            throw new IllegalArgumentException("A capacidade não pode ser menor que 1.");
        }
        this.capacidade = capacidade;
    }

    private void setFatorCrescimento(int fatorCrescimento) {
        if (fatorCrescimento < 0) {
            throw new IllegalArgumentException("O fator de crescimento não pode ser menor que 0.");
        }
        this.fatorCrescimento = fatorCrescimento;
    }

    @Override
    public void push(Object item){
        if (this.topo >= this.capacidade-1) {
            if (this.fatorCrescimento == 0) {
                this.capacidade *= 2;
            } else {
                this.capacidade += fatorCrescimento;
            }

            Object[] novoArray = new Object[this.capacidade];

            for (int i = 0; i < this.size(); i++) {
                novoArray[i] = items[i];
            }
            items = novoArray;
        }
        this.items[++topo] = item;
    }

    @Override
    public Object pop(){
        if (this.isEmpty()) {
            throw new PilhaVazia("A pilha está vazia!");
        }

        Object topoAtual = items[topo--];

        if (this.size() <= this.capacidade / 3 && this.capacidade > 2) {
            this.capacidade /= 2;

            Object[] novoArray = new Object[this.capacidade];

            for (int i = 0; i < this.size(); i++) {
                novoArray[i] = items[i];
            }
            items = novoArray;
        }

        return topoAtual;
    }

    @Override
    public Object top(){
        if (this.isEmpty()) {
            throw new PilhaVazia("A pilha está vazia!");
        }
        return items[topo];
    }

    @Override
    public int size(){
        return topo + 1;
    }

    @Override
    public boolean isEmpty(){
        return this.topo == -1;
    }
}