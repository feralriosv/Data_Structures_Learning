package linear.list;

public class Node {
    private int[] values;
    private int capacity;
    private Node next;
    private Node prev;
    private int count;

    public Node(int capacity) {
        this.capacity = capacity;
        values = new int[capacity];
        next = null;
        prev = null;
        count = 0;
    }

    protected boolean addLast(int element) {
        if (isFull()) {
            Node newNext = new Node(capacity);
            this.next = newNext;
            newNext.prev = this;
            newNext.values[0] = element;
            newNext.count++;
            return true;
        } else {
            values[count] = element;
            count++;
            return false;
        }
    }

    public boolean hasNext() {
        return next != null;
    }

    public Node next() {
        return next;
    }

    private boolean isFull() {
        return count == capacity;
    }
}
