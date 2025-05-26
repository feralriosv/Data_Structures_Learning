package hashing;

public class MyHashTable<K, V> implements IMyHashing<K, V> {
    public static final int MAXIMUM_CAPACITY = 15;

    private final HashEntry<K, V>[] entries;
    private int capacity;
    private int count;
//    private int loadFactor;

    public MyHashTable(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        }

        if (initialCapacity == 0) {
            initialCapacity = 1;
        }
        //noinspection unchecked
        entries = (HashEntry<K, V>[]) new HashEntry[Math.min(initialCapacity, MAXIMUM_CAPACITY)];
        this.capacity = initialCapacity;
    }

    @Override
    public void insert(K key, V value) {
        if (key == null) return;
        int hashCode = hash(key);
//        Empty chain
        if (entries[hashCode] == null) {
            entries[hashCode] = new HashEntry<>(hashCode, key, value, null);
            count++;
            return;
        }
//        Checks if key already exists => O(n)
        for (HashEntry<K, V> entry : entries[hashCode]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
//        Adds the new node at the beginning of the chain => O(1)
        entries[hashCode] = new HashEntry<>(hashCode, key, value, entries[hashCode]);
        count++;
    }

    @Override
    public V find(K key) {
        if (key == null) return null;
        int hashCode = hash(key);
        if (entries[hashCode] == null) return null;
//        Looks up the key along the chain
        for (HashEntry<K, V> entry : entries[hashCode]) {
            if (entry.matches(hashCode, key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        if (key == null) return false;
        int hashCode = hash(key);

        HashEntry<K, V> head = entries[hashCode];
        if (head == null) return false;

        HashEntry<K, V> prev = null;
        for (HashEntry<K, V> current = head; current != null; current = current.getNext()) {
            if (current.matches(hashCode, key)) {
                if (prev != null) {
                    prev.setNext(current.getNext());
                } else {
                    entries[hashCode] = current.getNext();
                }
                return true;
            }
            prev = current;
        }
        return false;
    }

    public int size() {
        return count;
    }

    public int hash(K key) {
        int hashCode = Math.abs(key.hashCode());
        if (hashCode == Integer.MIN_VALUE) return 0;

        String hashString = Integer.toString(hashCode);
        if (hashString.length() == 1) return hashCode % capacity;

        return fold(hashString);
    }

    private int fold(String value) {
        String first = value.substring(0, value.length() / 2);
        String second = value.substring(value.length() / 2);
        return  (Integer.parseInt(first) + Integer.parseInt(second)) % capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
