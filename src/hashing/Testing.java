package hashing;

public class Testing {
    public static void main(String[] args) {
        MyHashTable<String, Integer> myHashTable = new MyHashTable<>(12);
        myHashTable.insert("Fernando", 1);
        myHashTable.insert("16", 20);
        System.out.println(myHashTable.find("Fernando"));
    }
}
