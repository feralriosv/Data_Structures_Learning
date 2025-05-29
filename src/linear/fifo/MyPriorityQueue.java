package linear.fifo;

import java.util.Collection;

public class MyPriorityQueue<E> implements IMyQueue<E> {

    private E[] data;
    private int size;

    public MyPriorityQueue(int capacity) {
        //noinspection unchecked
        data = (E[]) new Object[capacity];
        size = 0;
    }

    @Override
    public boolean enqueue(E e) {
        return false;
    }

    @Override
    public boolean dequeue() {
        return false;
    }

    @Override
    public void remove() {

    }
}
