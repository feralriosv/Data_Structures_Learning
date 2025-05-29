package linear.fifo;

public interface IMyQueue<E> {
    boolean enqueue(E e);
    boolean dequeue();
    void remove();
}
