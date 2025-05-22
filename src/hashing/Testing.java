package hashing;

import java.util.HashSet;

public class Testing {
    public static void main(String[] args) {
        MyHashTable<String> myHashTable = new MyHashTable<>();
        HashSet<String> ds = new HashSet<>(0, 12);
        System.out.println(myHashTable.applyHash("Fernando"));
    }
}
