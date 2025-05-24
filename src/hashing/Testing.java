package hashing;

import java.util.HashSet;

public class Testing {
    public static void main(String[] args) {
        MyHashTable<String, Integer> myHashTable = new MyHashTable<>(12);
        myHashTable.insert("Fernando", 19);
        System.out.println(myHashTable.find("Fernando"));
    }
}
