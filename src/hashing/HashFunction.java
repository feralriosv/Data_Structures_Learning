package hashing;


public class HashFunction<K, V> {
    private final MyHashTable<K, V> table;

    public HashFunction(MyHashTable<K, V> table) {
        this.table = table;
    }

    protected int apply(K key) {
        int hashCode = Math.abs(key.hashCode());
        if (hashCode == Integer.MIN_VALUE) return 0;

        String hashString = Integer.toString(hashCode);
        if (hashString.length() == 1) return hashCode % table.getCapacity();

        return fold(hashString);
    }

    private int fold(String value) {
        String first = value.substring(0, value.length() / 2);
        String second = value.substring(value.length() / 2);
        return  (Integer.parseInt(first) + Integer.parseInt(second)) % table.getCapacity();
    }

}
