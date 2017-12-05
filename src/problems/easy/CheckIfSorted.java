package problems.easy;
/*
    Write an algorithm that determines whether a linked list is sorted.
 */
public class CheckIfSorted {
    private int size;
    private ListNode head;
    private ListNode tail;

    public boolean ifSorted(){
        ListNode temp = head;
        int lastElem = Integer.MIN_VALUE;
        while(temp != null){
            if(temp.elem < lastElem) return false;
            lastElem = temp.elem;
            temp = temp.next;
        }
        return true;
    }

    private class ListNode {
        private Integer elem;
        private ListNode next;
    }
}
