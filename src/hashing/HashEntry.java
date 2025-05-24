package hashing;

import java.util.Iterator;

public class HashEntry<K, V> implements Iterable<HashEntry<K, V>> {
    private final K key;
    private V value;
    private int hashCode;
    private final HashEntry<K, V> next;

    public HashEntry(int hashCode, K key, V value, HashEntry<K, V> next) {
        this.hashCode = hashCode;
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
