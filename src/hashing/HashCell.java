package hashing;

import java.util.LinkedList;

public class HashCell<T> {
    private LinkedList<T> elements;
    private int cellSize;

    public HashCell() {
        this.elements = new LinkedList<>();
        cellSize = 0;
    }

    public boolean add(T o) {
        return elements.add(o);
    }

    public int getAmountElements() {
        return cellSize;
    }

    public boolean isEmpty() {
        return cellSize > 0;
    }
}
