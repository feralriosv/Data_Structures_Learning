package linear.list;

public class Node {
    private final int[] values;
    private final int capacity;
    private Node next;
    private Node prev;
    private int dataCount;

    public Node(int capacity) {
        this.capacity = capacity;
        values = new int[capacity];
        next = null;
        prev = null;
        dataCount = 0;
    }

    protected void addLast(int element) {
        values[dataCount] = element;
        dataCount++;
    }

    protected void removeLast() {
        values[dataCount] = 0;
        dataCount--;
    }

    public void clear() {
        prev.next = null;
        this.prev = null;
        values[dataCount] = 0;
        dataCount = 0;
    }

    public boolean isFull() {
        return dataCount == capacity;
    }

    public boolean emptyAfterRemove() {
        return dataCount == 1;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
