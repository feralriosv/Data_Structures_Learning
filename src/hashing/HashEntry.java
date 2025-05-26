package hashing;

import java.util.Iterator;

public class HashEntry<K, V> implements Iterable<HashEntry<K, V>> {
    private final K key;
    private V value;
    private final int hash;
    private HashEntry<K, V> next;

    public HashEntry(int hash, K key, V value, HashEntry<K, V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public HashEntry<K, V> getNext() {
        return next;
    }

    public void setNext(HashEntry<K, V> next) {
        this.next = next;
    }

    //    Simplifies conditionals
    public boolean matches(int inputHash, K inputKey) {
        return this.hash == inputHash && this.key.equals(inputKey);
    }

    @Override
    public Iterator<HashEntry<K, V>> iterator() {
        return new Iterator<>() {
            private HashEntry<K, V> current = HashEntry.this;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public HashEntry<K, V> next() {
                HashEntry<K, V> helper = current;
                current = current.next;
                return helper;
            }
        };
    }
}
