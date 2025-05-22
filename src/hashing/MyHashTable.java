package hashing;

import java.util.ArrayList;
import java.util.List;

public class MyHashTable<T> implements IMyHashing {
    private static class HashCell<T>{
        private List<T> elements;
        private int size;

        public HashCell() {
            this.elements = new ArrayList<T>();
            this.size = 0;
        }
    }
    private List<HashCell<T>> cells;
    private int size;
    private int loadFactor;

    public MyHashTable() {
        cells = new ArrayList<>();
        size = 0;
    }

    public int applyHash(T t) {
        int key = (int) t % 2;
        return key;
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
