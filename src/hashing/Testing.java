package hashing;

import java.util.HashSet;
import java.util.LinkedList;

public class Testing {
    public static void main(String[] args) {
        MyHashTable<String> myHashTable = new MyHashTable<>(12);
        HashSet<String> ds = new HashSet<>(1, 12);
        String name = "Fernando";
        System.out.println(myHashTable.hashFunction(name));
    }
}
