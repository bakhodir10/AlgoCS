package ds.tree;

public interface Tree<E> {

    void insert(E elem);

    boolean search(E elem);

    void delete(E elem);

    void print();
}
