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
        int hashCode = Math.abs(o.hashCode());

        if (hashCode == Integer.MIN_VALUE) return 0;

        String hashString = Integer.toString(hashCode);

        if (hashString.length() == 1) return hashCode % size;

        return fold(hashString);
    }

    private int fold(String value) {
        String first = value.substring(0, value.length() / 2);
        String second = value.substring(value.length() / 2);
        return  (Integer.parseInt(first) + Integer.parseInt(second)) % size;
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
