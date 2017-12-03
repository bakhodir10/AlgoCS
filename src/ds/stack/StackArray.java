package ds.stack;

import java.util.NoSuchElementException;

public class StackArray<E> {
    public int size;
    private Object[] arr;
    private int INITIAL_CAPACITY = 12;

    public StackArray() {
        arr = new Object[INITIAL_CAPACITY];
    }

    public void push(E elem) {
        if (arr.length == size) increase();
        arr[size++] = elem;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if (size == 0) throw new NoSuchElementException();
        Object temp = arr[size - 1];
        arr[size - 1] = null;
        size--;
        if (size == arr.length - INITIAL_CAPACITY) decrease();
        return (E) temp;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if (size == 0) throw new NoSuchElementException();
        return (E) arr[0];
    }

    private void increase() {
        Object[] obj = new Object[arr.length + INITIAL_CAPACITY];
        System.arraycopy(arr, 0, obj, 0, arr.length);
        arr = obj;
    }

    private void decrease() {
        Object[] obj = new Object[arr.length - INITIAL_CAPACITY];
        System.arraycopy(arr, 0, obj, 0, size);
        arr = obj;
    }

    public String toString() {
        if (arr.length == 0) return "[]";
        StringBuilder b = new StringBuilder();
        b.append("[");
        for (int i = 0; i < size; i++) {
            b.append(arr[i]);
            if (i != size - 1) b.append(", ");
        }
        b.append("]");
        return b.toString();
    }
}
