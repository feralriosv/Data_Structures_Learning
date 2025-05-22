package hashing;

import java.util.ArrayList;
import java.util.List;

public class MyHashTable<T> implements IMyHashing<T> {
    public static final int MAXIMUM_CAPACITY = 15;

    private List<HashCell<T>> cells;
    private final int size;
    private int loadFactor;

    public MyHashTable(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialSize);
        }

        this.size = Math.min(initialSize, MAXIMUM_CAPACITY);
        cells = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            cells.add(new HashCell<>());
        }
    }

    public int hashFunction(Object o) {
        int elementHash = o.hashCode();
        return elementHash % size;
    }

    @Override
    public void insert(T t) {
        int key = hashFunction(t);
        cells.get(key).add(t);
    }

    @Override
    public T remove(int elementKey) {
        return null;
    }

    @Override
    public T find(int elementKey) {
        return null;
    }
}
