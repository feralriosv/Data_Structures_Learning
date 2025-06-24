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
            heap[totalElements] = element;
            siftUp(totalElements);
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
        heap[0] = 0;
        totalElements--;
        siftDown(0);
        return result;
    }

    private void siftDown(int fatherIndex) {
        int lowestSonIndex;
        int leftSon = 2 * fatherIndex + 1;
        int rightSon = 2 * fatherIndex + 2;

        if (leftSon < totalElements && heap[leftSon] <= heap[rightSon]) {
            lowestSonIndex = leftSon;
        } else if (rightSon < totalElements && heap[leftSon] > heap[rightSon]){
            lowestSonIndex = rightSon;
        } else {
            lowestSonIndex = totalElements;
        }

        if (heap[fatherIndex] < heap[lowestSonIndex]) {
            swipe(fatherIndex, lowestSonIndex);
            siftDown(lowestSonIndex);
        }
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;

            if (heap[parentIndex] > heap[index]) {
                swipe(parentIndex, index);
                index = parentIndex;
            } else {
                break;
            }
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
