package ds.tree;

public interface Tree<T> {

    void insert(T elem);

    boolean search(T elem);

    void delete(T elem);

    void print();
}
