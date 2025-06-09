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
        values[totalElements - 1] = 0;
        totalElements--;
        // Indicates if node is empty after element removal.
        return totalElements == 0;
    }

    protected boolean isFull() {
        return totalElements == capacity;
    }

    protected boolean hasNext() {
        return next != null;
    }

    protected void setNext(Node next) {
        this.next = next;
    }

    protected Node getPrev() {
        return prev;
    }

    protected void setPrev(Node prev) {
        this.prev = prev;
    }

    protected Node getNext() {
        return next;
    }

    protected int size() {
        return totalElements;
    }

    protected int valueAt(int index) {
        return values[index];
    }

    protected String toString(String separator) {
        StringBuilder nodeContent = new StringBuilder();
        int lastElementIndex = totalElements - 1;
        for (int i = 0; i < lastElementIndex; i++) {
            nodeContent.append(values[i]).append(separator);
        }
        nodeContent.append(values[lastElementIndex]);
        return nodeContent.toString();
    }
}
