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

    /**
     * Adds an element to the end of this node's internal array.
     *
     * @param element the element to add
     */
    protected void addLast(int element) {
        values[totalElements] = element;
        totalElements++;
    }

    /**
     * Removes the last element from this node's internal array.
     *
     * @return true if the node is empty and has a previous node, false otherwise
     */
    protected boolean removeLast() {
        values[totalElements - 1] = 0;
        totalElements--;
        // Indicates if node is empty after element removal.
        return totalElements == 0;
    }

    /**
     * Checks whether this node's internal array is full.
     *
     * @return true if the node's array is full, false otherwise
     */
    protected boolean isFull() {
        return totalElements == capacity;
    }

    protected boolean hasNext() {
        return next != null;
    }

    /**
     * Sets the reference to the next node in the list.
     *
     * @param next the next node
     */
    protected void setNext(Node next) {
        this.next = next;
    }

    /**
     * Returns the reference to the previous node in the list.
     *
     * @return the previous node
     */
    protected Node getPrev() {
        return prev;
    }

    /**
     * Sets the reference to the previous node in the list.
     *
     * @param prev the previous node
     */
    protected void setPrev(Node prev) {
        this.prev = prev;
    }

    /**
     * Returns the reference to the next node in the list.
     *
     * @return the next node
     */
    protected Node getNext() {
        return next;
    }

    /**
     * Gives the amount of elements in the current node.
     *
     * @return The amount of elements in the current node.
     */
    protected int size() {
        return totalElements;
    }

    /**
     * Returns the value at the specified index in this node's internal array.
     *
     * @param index the position of the element to retrieve (must be between 0 and totalElements - 1)
     * @return the value at the specified index
     */
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
