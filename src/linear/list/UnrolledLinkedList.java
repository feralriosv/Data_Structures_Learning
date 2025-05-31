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
        if (tail.isFull()) {
            Node newTail = new Node(tail.getCapacity());
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
        if (tail.emptyAfterRemove()) {
            Node newTail = tail.getPrev();
            tail.clear();
            tail = newTail;
            return true;
        } else {
            tail.removeLast();
            return false;
        }
    }

    public int amountArrays() {
        return 1;
    }

    public int size() {
        return totalCount;
    }

    private boolean isEmpty() {
        return totalCount == 0;
    }
}
