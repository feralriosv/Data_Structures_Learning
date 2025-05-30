package linear.list;

public class UnrolledLinkedList {
    private Node tail;
    private int totalCount;

    public UnrolledLinkedList(int arraySize) {
        this.tail = new Node(arraySize);
        totalCount = 0;
    }

    public boolean push(int element) {
        totalCount++;
        return tail.addLast(element);
    }

    public boolean pop() {

    }

    public int size() {
        return totalCount;
    }
}
