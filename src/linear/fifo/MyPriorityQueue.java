package linear.fifo;

public class MyPriorityQueue<E extends Comparable<E>> implements IMyQueue<E> {

    private final E[] data;
    private int size;
    private final int capacity;

    public MyPriorityQueue(int capacity) {
        this.capacity = capacity;
        //noinspection unchecked
        data = (E[]) new Comparable[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean enqueue(E e) {
        if (capacity == size) return false;

        int index = size - 1;

//        Iterates over elements and shifts the greater ones to the right
        while (index >= 0 && e.compareTo(data[index]) < 0) {
            data[index + 1] = data[index];
            index--;
        }

//        Re-establishes the index
        data[index + 1] = e;
        size++;
        return false;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;

        E value = data[0];

        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;
        return value;
    }

    @Override
    public void remove() {

    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (isEmpty()) {
            return "[]";
        }
        s.append("[");
        for (int i = 0; i < size; i++) {
            s.append(data[i]);
            if (i < size - 1) {
                s.append(", ");
            }
        }
        s.append("]");
        return s.toString();
    }
}
