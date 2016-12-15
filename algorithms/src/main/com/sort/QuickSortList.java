package com.sort;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class QuickSortList {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  };

  public ListNode sortList(ListNode head) {
    return sortList(head, null);
  }

  private ListNode sortList(ListNode head, ListNode end) {
    if (head != end) {
      ListNode part = partition(head, end);
      sortList(head, part);
      sortList(part.next, end);
    }
    return head;
  }

  private ListNode partition(ListNode head, ListNode end) {
    ListNode mid = mid(head, end);

    int val = mid.val;
    mid.val = head.val;
    head.val = val;

    ListNode low = head;
    ListNode itr = head.next;

    while (itr != end) {
      if (itr.val < val) {
        low = low.next;
        int tmp = low.val;
        low.val = itr.val;
        itr.val = tmp;
      }
      itr = itr.next;
    }

    int tmp = low.val;
    low.val = head.val;
    head.val = tmp;
    return low;
  }

  private ListNode mid(ListNode head, ListNode end) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast != end && fast.next != null && fast.next != end) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
}