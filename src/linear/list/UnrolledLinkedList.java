package linear.list;

public class UnrolledLinkedList {
    private Node head;
    private Node tail;
    private final int arraySize;
    private int totalArrays;
    private int totalElements;

    public UnrolledLinkedList(int arraySize) {
        this.arraySize = arraySize;;
        totalElements = 0;
        head = null;
        tail = null;
    }

    public boolean push(int element) {
        totalElements++;
        if (tail.isFull()) {
            Node newTail = new Node(arraySize);
            tail.setNext(newTail);
            newTail.setPrev(tail);
            tail = newTail;
            newTail.addLast(element);
            return true;
        } else {
            tail.addLast(element);
            return false;
        }
    }

    public boolean pop() {
        if (isEmpty()) return false;
        totalElements--;
        Node newTail = tail.getPrev();
        if (tail.removeLast()) {
            tail = newTail;
            return true;
        }
        return false;
    }

    public int sizeArray(int index) {
        return -1;
    }


    public int amountArrays() {
        return totalArrays;
    }

    public int size() {
        return totalElements;
    }

    public String toString(String separator) {
        return "";
    }

    public boolean isEmpty() {
        return totalElements == 0;
    }
}
