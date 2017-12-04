package ds.queue;

import java.util.NoSuchElementException;

public class QueueArray<E> {
    private final int INITIAL_CAPACITY = 2;
    private Object[] arr;
    private int target;

    public QueueArray() {
        this.arr = new Object[INITIAL_CAPACITY];
        target = this.arr.length;
    }

    public QueueArray(int len) {
        this.arr = new Object[len];
        target = len;
    }

    public void offer(E elem) {
        if(elem == null) throw new NullPointerException();
        if (target == 0) resize();
        arr[--target] = elem;
    }

    @SuppressWarnings("unchecked")
    public E poll() {
        if (target == 0) resize();
        E em = (E) arr[target];
        arr[target++] = null;
        return em;
    }

    @SuppressWarnings("unchecked")
    public E element() {
        if (target == 0) throw new NoSuchElementException();
        return (E) arr[target];
    }

    private void resize() {
        Object temp[] = new Object[arr.length + INITIAL_CAPACITY];
        int k = temp.length;
        for (int i = arr.length - 1; i >= 0; i--) {
            temp[--k] = arr[i];
        }
        target = k;
        arr = temp;
    }

    public String toString() {
        if (arr.length == 0) return "[]";
        StringBuilder b = new StringBuilder();
        b.append("[");
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != null) b.append(arr[i]);
            if (i != 0 && arr[i - 1] != null) b.append(", ");
        }
        b.append("]");
        return b.toString();
    }
}
