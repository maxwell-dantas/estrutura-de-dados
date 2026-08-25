package pilha.rubroNegra;

import pilha.PilhaVazia;

public class PilhaRubroNegra {
    private Object[] rubroNegra;
    private int topoVermelho;
    private int topoPreto;
    private int capacidade;

    public PilhaRubroNegra(int capacidade) {
        this.setCapacidade(capacidade);
        rubroNegra = new Object[capacidade];
        this.topoVermelho = -1;
        this.topoPreto = this.capacidade;
    }

    private void setCapacidade(int capacidade) {
        if (capacidade < 3) {
            throw new IllegalArgumentException("A capacidade mínima deve ser 3");
        }
        this.capacidade = capacidade;
    }

    private void increaseOrReduceCapacity(int select) {
        int cacheSizePreta = this.sizePreto(); // salva o estado atual do tamanho (o cálculo é alterado quando modifica a capacidade)

        if (select == 0) {
            this.capacidade *= 2;
        } else if (select == 1) {
            this.capacidade /= 2;
        }

        Object[] newRubroNegra = new Object[this.capacidade];

        for (int i = 0; i < this.sizeVermelho(); i++) {
            newRubroNegra[i] = this.rubroNegra[i];
        }

        for (int i = this.capacidade - cacheSizePreta; i < this.capacidade; i++) {
            newRubroNegra[i] = this.rubroNegra[this.topoPreto];
            this.topoPreto++;
        }

        this.topoPreto = this.capacidade - cacheSizePreta;
        rubroNegra = newRubroNegra;
    }

    public int sizeVermelho() {
        return this.topoVermelho + 1;
    }

    public int sizePreto() {
        return this.capacidade - this.topoPreto;
    }

    public int size() {
        return this.sizeVermelho() + this.sizePreto();
    }

    public boolean isEmptyVermelho() {
        return this.topoVermelho == -1;
    }

    public boolean isEmptyPreto() {
        return this.topoPreto == this.capacidade;
    }

    public void pushVermelho(Object item) {
        if (this.size() == this.capacidade) {
            this.increaseOrReduceCapacity(0);
        }
        this.rubroNegra[++topoVermelho] = item;
    }

    public void pushPreto(Object item) {
        if (this.size() == this.capacidade) {
            this.increaseOrReduceCapacity(0);
        }
        this.rubroNegra[--topoPreto] = item;
    }

    public Object popVermelho() {
        if (this.isEmptyVermelho()) {
            throw new PilhaVazia("A pilha está vazia!");
        }

        if (this.size() <= this.capacidade / 3 && this.capacidade > 3) {
            this.increaseOrReduceCapacity(1);
        }

        Object itemRemovido = rubroNegra[this.topoVermelho];
        rubroNegra[this.topoVermelho] = null;
        this.topoVermelho--;
        return itemRemovido;
    }

    public Object popPreto() {
        if (this.isEmptyPreto()) {
            throw new PilhaVazia("A pilha está vazia!");
        }

        if (this.size() <= this.capacidade / 3 && this.capacidade > 3) {
            this.increaseOrReduceCapacity(1);
        }

        Object itemRemovido = rubroNegra[this.topoPreto];
        rubroNegra[this.topoPreto] = null;
        this.topoPreto++;
        return itemRemovido;
    }

    public Object topVermelho() {
        if (this.isEmptyVermelho()) {
            throw new PilhaVazia("A pilha está vazia!");
        }
        return rubroNegra[this.topoVermelho];
    }

    public Object topoPreto() {
        if (this.isEmptyPreto()) {
            throw new PilhaVazia("A pilha está vazia!");
        }
        return rubroNegra[this.topoPreto];
    }
}