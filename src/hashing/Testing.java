package hashing;

import java.util.HashSet;

public class Testing {
    public static void main(String[] args) {
        MyHashTable<String> myHashTable = new MyHashTable<>(12);
        String name = "Fernando";
        System.out.println(myHashTable.hashFunction(name));
        String second = "7";
        System.out.println(myHashTable.hashFunction(second));
        int o1 = 10000000;
        System.out.println(myHashTable.hashFunction(o1));
    }
}
