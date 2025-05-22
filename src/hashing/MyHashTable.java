package hashing;

import java.util.ArrayList;
import java.util.List;

public class MyHashTable<T> implements IMyHashing {
    public static final int MAXIMUM_CAPACITY = 15;

    private static class HashCell<T>{
        private List<T> elements;
        private int size;

        public HashCell() {
            this.elements = new ArrayList<>();
            this.size = 0;
        }
    }

    private List<HashCell<T>> cells;
    private final int size;
    private int loadFactor;

    public MyHashTable(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialSize);
        }
        if (initialSize > MAXIMUM_CAPACITY) {
            this.size = MAXIMUM_CAPACITY;
        } else {
            this.size = initialSize;
        }
        cells = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            cells.add(new HashCell<>());
        }
    }

    public int applyHash(T t) {
        int elementHash = t.hashCode();
        return elementHash % size;
    }

    @Override
    public void insert(Object o) {

    }

    @Override
    public Object remove(int elementKey) {
        return null;
    }

    @Override
    public Object find(int elementKey) {
        return null;
    }
}
