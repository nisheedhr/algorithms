package com.datastructures;

public class ReverseLinkedList {

    private static class ListNode {
        private ListNode next;
    }
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        return reverse (null, head);
    }
    
    private ListNode reverse(ListNode prev, ListNode cur) {
        if (cur.next == null) {
            cur.next = prev;
            return cur;
        } else {
            ListNode next = cur.next;
            cur.next = prev;
            return reverse(cur, next);
        }
    }
}
