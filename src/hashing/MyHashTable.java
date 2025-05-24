package hashing;

public class MyHashTable<K, V> implements IMyHashing<K, V> {
    public static final int MAXIMUM_CAPACITY = 15;

    private final HashEntry<K, V>[] entries;
    private final int size;
//    private int loadFactor;

    public MyHashTable(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialSize);
        }

        //noinspection unchecked
        entries = (HashEntry<K, V>[]) new HashEntry[Math.min(initialSize, MAXIMUM_CAPACITY)];
        this.size = entries.length;
    }

    @Override
    public void insert(K key, V value) {
        int hashCode = hash(key);
//        Empty chain
        if (entries[hashCode] == null) {
            entries[hashCode] = new HashEntry<>(hashCode, key, value, null);
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
    }

    @Override
    public V find(K key) {
        int hashCode = hash(key);
//        Looks up the key along the chain
        for (HashEntry<K, V> entry : entries[hashCode]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

//    TO-DO: Implement Method
    @Override
    public V remove(K key) {
        return null;
    }

    public int hash(K key) {
        int hashCode = Math.abs(key.hashCode());
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
}
