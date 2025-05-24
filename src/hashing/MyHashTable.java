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
        entries[hash(key)] = new HashEntry<>(hash(key), key, value);
    }

//    TODO: Check if works good
    @Override
    public V find(K key) {
        return entries[hash(key)].getValue();
    }

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
