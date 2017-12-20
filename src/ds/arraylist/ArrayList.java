package ds.arraylist;

/*
    implementation methods of ArrayList
 */
public class ArrayList<E> {
    private final int INITIAL_CAPACITY = 12;
    private transient Object[] arr;
    private int size;

    public ArrayList() {
        arr = new Object[INITIAL_CAPACITY];
    }

    public ArrayList(int initialCapacity) {
        arr = new Object[initialCapacity];
    }

    public void add(E elem) {
        if (elem == null) throw new NullPointerException();
        if (size == arr.length) resize();
        arr[size++] = elem;
    }

    public void add(int index, E elem) {
        checkRange(index);
        if (elem == null) throw new NullPointerException();
        if (size == arr.length) resize();

        Object temp = arr[index];
        arr[index] = elem;
        for (int i = index + 1; i < size + 1; i++) {
            Object val = arr[i];
            arr[i] = temp;
            temp = val;
        }
        size++;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (size < 0) throw new NullPointerException();

        Object oldValue = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return (E) oldValue;
    }

    public boolean remove(E elem) {
        if (elem == null) throw new NullPointerException();
        int index = indexOf(elem);
        if (index == -1) return false;

        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return true;
    }

    public int indexOf(E elem) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(elem)) return i;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E elem) {
        return indexOf(elem) != -1;
    }


    private void resize() {
        Object[] temp = new Object[arr.length + INITIAL_CAPACITY];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        arr = temp;
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        if (size == 0) return b.append("[]").toString();
        b.append("[");
        for (int i = 0; i < size - 1; i++) {
            b.append(arr[i]).append(", ");
        }
        b.append(arr[size - 1]).append("]");
        return b.toString();
    }

    private void checkRange(int index) {
        if (index > size) throw new NullPointerException();
    }
}
