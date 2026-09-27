package sequence.array;

import sequence.Position;

class ArrayPosition implements Position {
    private Object element;
    private int index;

    public ArrayPosition(Object element, int index) {
        this.element = element;
        this.index = index;
    }

    @Override
    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}