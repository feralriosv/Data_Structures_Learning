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

    protected void setValue(V value) {
        this.value = value;
    }

    protected K getKey() {
        return key;
    }

    protected V getValue() {
        return value;
    }

    protected HashEntry<K, V> getNext() {
        return next;
    }

    protected void setNext(HashEntry<K, V> next) {
        this.next = next;
    }

    //    Simplifies conditionals
    protected boolean matches(int inputHash, K inputKey) {
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
