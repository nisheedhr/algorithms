package com.twopointer;


/**
 * Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 * @author nisheedh
 *
 */
public class PalindromeList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    };
    
    private class Result {
        ListNode fwd;
        boolean status;
    }
    /**
     * Use 2 pointers, slow and fast. Once fast cannot move further, compare
     * slow with return of recursive call. If it matches return next element
     * else return null
     * Handle odd number and even number of elements in recursive call base case.
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        Result res = new Result();
        compareNodes(slow,fast, res);
        return res.status;
    }

    private void compareNodes(ListNode slow, ListNode fast, Result res) {
        if (fast.next == null) { // odd number of elements
            res.status = true;
            res.fwd =  slow;
        } else if (fast.next.next == null) { // even number of elements
            res.fwd =  slow.next;
            res.status = res.fwd.val == slow.val;
        } else {
            compareNodes(slow.next, fast.next.next, res);
            if (res.status == true) {
                res.fwd = res.fwd.next;
                res.status = res.fwd.val == slow.val;
            } else {
                res.status = false;
                res.fwd = null;
            }
        }
    }
    
}
