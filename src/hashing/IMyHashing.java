package hashing;

public interface IMyHashing<K, V>{
    void insert(K key, V value);
    V remove(K elementKey);
    V find(K elementKey);
}
