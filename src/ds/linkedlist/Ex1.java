package ds.linkedlist;

public class Ex1 {
    public static void main(String args[]){
        SingleLinkedList<Integer> list = new SingleLinkedList();
//        list.add(13);
        list.add(-1);
        list.add(34);
        list.add(9);
        list.add(-11);
        list.insertionSort();
    }
}
