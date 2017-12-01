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
        if (arr.length == size) resize();
        arr[size++] = elem;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if (size == arr.length) throw new NoSuchElementException();
        Object temp = arr[size - 1];
        arr[size - 1] = null;
        size--;
        return (E) temp;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if (size == 0) throw new NoSuchElementException();
        return (E) arr[0];
    }

    private void resize() {
        Object[] obj = new Object[arr.length + INITIAL_CAPACITY];
        System.arraycopy(arr, 0, obj, 0, arr.length);
        arr = obj;
    }

    public void iterate() {
        for (int i = 0; i < size; i++) System.out.println(arr[i]);
    }
}
