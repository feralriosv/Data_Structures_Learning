package linear.fifo;

public class MyPriorityQueue<E extends Comparable<E>> implements IMyQueue<E> {

    private E[] data;
    private int count;
    private int capacity;

    public MyPriorityQueue(int capacity) {
        this.capacity = capacity;
        //noinspection unchecked
        data = (E[]) new Comparable[capacity];
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void clear() {
        for (int i = 0; i < count; i++) {
            data[i] = null;
        }
        count = 0;
    }

//    Compares if two Queues are exactly the same
    public boolean equals(MyPriorityQueue<E> other) {
        if (count != other.count) return false;
        for (int i = 0; i < count; i++) {
            if (!this.data[i].equals(other.data[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean contains(E e) {
        int left = 0;
        int right = count - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = e.compareTo(data[mid]);

            if (comparison == 0) return true;
            if (comparison < 0) right = mid - 1;
            else left = mid + 1;
        } // O(log(n))

        return false;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return data[0];
    }

    @Override
    public boolean enqueue(E e) {
        if (capacity == count) resize();

        int index = count - 1;

//        Iterates over elements and shifts the greater ones to the right
        while (index >= 0 && e.compareTo(data[index]) < 0) {
            data[index + 1] = data[index];
            index--;
        }

//        Re-establishes the index
        data[index + 1] = e;
        count++;
        return false;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;

//        Catches return value
        E value = data[0];

//        Shifts each value to the left
        for (int i = 0; i < count - 1; i++) {
            data[i] = data[i + 1];
        }

//        Removes last duplicate
        data[count - 1] = null;
        count--;
        return value;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Empty Queue");
        }
        dequeue();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (isEmpty()) {
            return "[]";
        }
        s.append("[");
        for (int i = 0; i < count; i++) {
            s.append(data[i]);
            if (i < count - 1) {
                s.append(", ");
            }
        }
        s.append("]");
        return s.toString();
    }

    private void resize() {
        //noinspection unchecked
        E[] resized = (E[]) new Comparable[this.capacity * 2];
        System.arraycopy(this.data, 0, resized, 0, data.length);
        data = resized;
        capacity = capacity * 2;
    }
}
