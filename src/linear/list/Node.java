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

    protected boolean removeLast() {
        values[dataCount] = 0;
        dataCount--;
        if (dataCount == 0 && prev != null) {
            prev.next = null;
            this.prev = null;
            return true;
        }
        return false;
    }

    public boolean hasPrev() {
        return prev != null;
    }

    public boolean isFull() {
        return dataCount == capacity;
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
