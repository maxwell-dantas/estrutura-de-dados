package atividadePilha;

import pilha.pilhaArray.PilhaArray;

public class Matrix {
    private PilhaArray red;
    private PilhaArray blue;

    public Matrix() {
        red = new PilhaArray(1, 0);
        blue = new PilhaArray(1, 0);
    }

    public void pushRed(Object item) {
        this.red.push(item);
    }

    public void pushBlue(Object item) {
        this.blue.push(item);
    }

    public Object popRed() {
        return this.red.pop();
    }

    public Object popBlue() {
        return this.blue.pop();
    }

    public Object pop() {
        if (!this.blue.isEmpty()) {
            return this.popBlue();
        }

        return this.popRed();
    }

    public Object top() {
        if (!this.blue.isEmpty()) {
            return this.blue.top();
        }

        return this.red.top();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int size() {
        return this.red.size() + this.blue.size();
    }
}
