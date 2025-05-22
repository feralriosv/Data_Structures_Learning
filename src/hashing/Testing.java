package hashing;

import java.util.HashSet;

public class Testing {
    public static void main(String[] args) {
        MyHashTable<String> myHashTable = new MyHashTable<>(12);
        HashSet<String> ds = new HashSet<>(-1, 12);
        System.out.println(myHashTable.applyHash("Fernando"));
    }
}
