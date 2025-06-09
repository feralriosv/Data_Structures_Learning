package linear.list;

public class UnrolledLinkedList {
    private Node head;
    private Node tail;
    private final int arraySize;
    private int totalArrays;
    private int totalElements;

    public UnrolledLinkedList(int arraySize) {
        this.arraySize = arraySize;
        totalArrays = 0;
        totalElements = 0;
        head = null;
        tail = null;
    }

    /**
     * Adds an element to the end of the unrolled linked list.
     *
     * @param element the element to add to the list
     * @return true if a new node was created, false if the element was added to the existing tail
     */
    public boolean push(int element) {
        totalElements++;
        if (head == null || tail.isFull()) { // Manages initial case
            Node newTail = new Node(arraySize);
            newTail.addLast(element);
            appendTail(newTail); // Simplifies code
            return true;
        } else {
            tail.addLast(element);
            return false;
        }
    }

    /**
     * Removed the last element of the unrolled linked list.
     *
     * @return true if an entire node was eliminated, false if only the element was removed
     */
    public boolean pop() {
        if (isEmpty()) return false;
        totalElements--;
        if (tail.removeLast()) {
            Node newTail = tail.getPrev();
            replaceTail(newTail); // Simplifies code
            return true;
        }
        return false;
    }

    /**
     * Gives the current size of the array at the specified index.
     *
     * @param index The index of the array in the UnrolledLinkedList
     * @return The size of the specified array.
     */
    public int sizeArray(int index) {
        int currentIndex = 0;
        Node current = head;
        while (currentIndex < index) {
            current = current.getNext();
            currentIndex++;
        }
        return current.size();
    }

    /**
     * Returns the element at the given global index within the unrolled linked list.
     *
     * @param index the global index of the element to retrieve (0-based).
     * @return the element at the specified index.
     */
    public int get(int index) {
        int targetArray = index / totalArrays;
        int elementIndex = index % totalArrays;
        int currentPos = 0;
        Node current = head;
        while (currentPos < targetArray) {
            current = current.getNext();
            currentPos++;
        }
        return current.valueAt(elementIndex);
    }

    /**
     * Gives the total amount of arrays in the UnrolledLinkedList.
     *
     * @return The total amount of array in the UnrolledLinkedList
     */
    public int amountArrays() {
        return totalArrays;
    }

    /**
     * Gives the amount of elements in the UnrolledLinkedList.
     *
     * @return The amount of elements in the UnrolledLinkedList
     */
    public int size() {
        return totalElements;
    }

    /**
     * Returns a string representation of the entire unrolled linked list.
     *
     * @param separator the string to separate each element
     * @return a string containing all elements of the list, separated by the specified separator
     */
    public String toString(String separator) {
        if (isEmpty()) {
            return "";
        }
        StringBuilder listContent = new StringBuilder();
        Node current = head;
        while (current.hasNext() && current != tail) {
            listContent.append(current.toString(separator));
            listContent.append(separator);
            current = current.getNext();
        }
        listContent.append(current.toString(separator)); // Appends tail without unnecessary ";"
        return listContent.toString();
    }

    /**
     * Checks whether the current UnrolledLinkedList has no element.
     *
     * @return true if the list has no element stored, otherwise false
     */
    public boolean isEmpty() {
        return totalElements == 0;
    }


    private void appendTail(Node newTail) {
        if (head == null) {
            head = newTail;
        } else {
            tail.setNext(newTail);
            newTail.setPrev(tail);
        }
        tail = newTail;
        tail.setNext(null);
        totalArrays++;
    }

    private void replaceTail(Node newTail) {
        if (newTail == null) {
            // Initial list state
            head = null;
            tail = null;
        } else {
            tail = newTail;
            tail.setNext(null);
        }
        totalArrays--;
    }
}
