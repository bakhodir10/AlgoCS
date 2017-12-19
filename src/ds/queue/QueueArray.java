package ds.queue;

import java.util.NoSuchElementException;

public class QueueArray<E> {
    private final int INITIAL_CAPACITY = 2;
    private Object[] arr;
    private int front = -1;
    private int rear = 0;

    public QueueArray() {
        this.arr = new Object[INITIAL_CAPACITY];
    }

    public QueueArray(int len) {
        this.arr = new Object[len];
    }

    public void offer(E elem) {
        if (elem == null) throw new NullPointerException();
        if (front == -1) front++;
        if (rear == arr.length) resize();
        arr[rear++] = elem;
    }

    @SuppressWarnings("unchecked")
    public E poll() {
        if (front == rear || front < 0) throw new NoSuchElementException();
        E em = (E) arr[front];
        arr[front++] = null;
        return em;
    }

    @SuppressWarnings("unchecked")
    public E element() {
        if (front == 0 || front == rear) throw new NoSuchElementException();
        return (E) arr[front];
    }

    public boolean isEmpty() {
        return front == -1 || front >= rear;
    }

    public int getSize() {
        return front == -1 ? 0 : rear - front;
    }

    private void resize() {
        Object temp[] = new Object[arr.length + INITIAL_CAPACITY];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        arr = temp;
    }

    public String toString() {
        if (arr.length == 0) return "[]";
        StringBuilder b = new StringBuilder();
        b.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) b.append(arr[i]).append(" ");
        }
        b.append("]");
        return b.toString();
    }
}
