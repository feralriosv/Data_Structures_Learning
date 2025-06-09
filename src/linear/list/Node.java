package linear.list;

public class Node {
    private final int[] values;
    private final int capacity;
    private Node next;
    private Node prev;
    private int totalElements;

    public Node(int capacity) {
        this.capacity = capacity;
        values = new int[capacity];
        next = null;
        prev = null;
        totalElements = 0;
    }

    protected void addLast(int element) {
        values[totalElements] = element;
        totalElements++;
    }

    protected boolean removeLast() {
        values[totalElements] = 0;
        totalElements--;
        // Indicates if node is empty after element removal.
        return totalElements == 0;
    }

    public boolean hasPrev() {
        return prev != null;
    }

    public boolean isFull() {
        return totalElements == capacity;
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
