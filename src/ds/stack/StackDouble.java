package ds.stack;

import java.util.NoSuchElementException;

public class StackDouble<E> {
    private Object[] arr;
    private int INITIAL_CAPACITY = 10;
    private int top1, top2;

    public StackDouble() {
        this.arr = new Object[INITIAL_CAPACITY];
        this.top1 = 0;
        this.top2 = arr.length - 1;
    }

    public void pushToStack1(E elem) {
        if (elem == null) throw new NoSuchElementException();
        if (top1 > top2 - 1) resize();
        arr[top1++] = elem;
    }

    public void pushToStack2(E elem) {
        if (elem == null) throw new NoSuchElementException();
        if (top1 > top2 - 1) resize();
        arr[top2--] = elem;
    }

    @SuppressWarnings("unchecked")
    public E popStack1() {
        if (top1 == -1) throw new NoSuchElementException();
        Object obj = arr[--top1];
        arr[top1] = null;
        return (E) obj;
    }

    @SuppressWarnings("unchecked")
    public E popStack2() {
        if (top2 == arr.length) throw new NoSuchElementException();
        System.out.println(top2);
        Object obj = arr[++top2];
        arr[top2] = null;
        return (E) obj;
    }

    private void resize() {

    }

    public void iterate() {
        for (Object o : arr) System.out.println(o);
    }
}
