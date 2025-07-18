package queue;

public interface IMyQueue<E> {
    boolean enqueue(E e);
    E dequeue();
    E peek();
    void remove();
}
