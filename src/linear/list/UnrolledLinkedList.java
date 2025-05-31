package linear.list;

public class UnrolledLinkedList {
    private Node tail;
    private final int arraySize;
    private int totalCount;

    public UnrolledLinkedList(int arraySize) {
        this.arraySize = arraySize;
        this.tail = new Node(arraySize);
        totalCount = 0;
    }

    public boolean push(int element) {
        totalCount++;
        System.out.println(totalCount);
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
        totalCount--;
        Node newTail = tail.getPrev();
        if (tail.removeLast()) {
            tail = newTail;
            return true;
        }
        return false;
    }

    public int amountArrays() {
        int counter = 1;
        Node copy = tail;
        while (copy.hasPrev()) {
            counter++;
            copy = copy.getPrev();
        }
        return counter;
    }

    public int size() {
        return totalCount;
    }

    public boolean isEmpty() {
        return totalCount == 0;
    }
}
