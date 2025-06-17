package heap;

import java.util.Arrays;

public class MinHeap {
    private final int[] heap;
    private final int capacity;
    private int elements;

    public MinHeap(int capacity) {
        this.heap = new int[capacity];
        this.capacity = capacity;
        this.elements = 0;
    }

    public void insert(int element) {
        if (!full()) {
            int index = elements;
            heap[index] = element;
            siftUp(index);
            elements++;
        }
    }

    public int peek() {
        return (capacity > 0)
                ? heap[0]
                : -1;
    }

    private void siftUp(int index) {
        if (index > 0 && heap[index / 2] > heap[index]) {
            swipe(index, index / 2);
            siftUp(index / 2);
        }
    }

    private void swipe(int index, int otherIndex) {
        int temp = heap[otherIndex];
        heap[otherIndex] = heap[index];
        heap[index] = temp;
    }

    private boolean full() {
        return capacity == elements;
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }
}
