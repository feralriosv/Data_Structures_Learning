package hashing;

public interface IMyHashing<T>{

    void insert(T t);
    T remove(int elementKey);
    T find(int elementKey);
}
