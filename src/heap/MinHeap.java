package heap;

import java.util.Arrays;

public class MinHeap {
    private final int[] heap;
    private final int capacity;
    private int totalElements;

    public MinHeap(int capacity) {
        this.capacity = Math.max(1, capacity);
        this.heap = new int[this.capacity];
        this.totalElements = 0;
    }

    public void insert(int element) {
        if (totalElements < capacity) {
            int index = totalElements;
            heap[index] = element;
            siftUp(index);
            totalElements++;
        }
    }

    public int peek() {
        return (capacity > 0)
                ? heap[0]
                : -1;
    }

    public int extractMin() {
        int result = heap[0];
        heap[0] = heap[totalElements - 1];
        totalElements--;
        siftDown(0);
        return result;
    }

    private void siftDown(int index) {
        int minSonIndex;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (heap[left] <= heap[right]) {
            minSonIndex = left;
        } else {
            minSonIndex = right;
        }

        if (heap[index] > heap[minSonIndex]) {
            swipe(index, minSonIndex);
            siftDown(minSonIndex);
        }
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

    public boolean isEmpty() {
        return totalElements == 0;
    }

    public int size() {
        return totalElements;
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }
}
