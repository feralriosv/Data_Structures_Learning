package hashing;

public class HashEntry<K, V> {
    private K key;
    private V value;
    private int hashCode;
    private HashEntry<K, V> next;

    public HashEntry(int hashCode, K key, V value) {
        this.hashCode = hashCode;
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    public void setNext(HashEntry<K, V> next) {
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public int getHashCode() {
        return hashCode;
    }

    public HashEntry<K, V> getNext() {
        return next;
    }
}
