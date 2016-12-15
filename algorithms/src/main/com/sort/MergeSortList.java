package com.sort;


public class MergeSortList {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  };

  /**
   * Key ideas
   * Use runner to find middle
   * merge sort from beg to mid (half open list)
   * mergesort from mid to end (half open list
   * For single element list . It has elements head.next == end. set head.next = null and return.
   * merge 2 lists starting from beg and mid. make sure that itr.next is set to null.
   * @param head
   * @return
   */
  public ListNode sortList(ListNode head) {
    return mergeSort(head, null);
  }

  private ListNode mergeSort(ListNode head, ListNode end) {
    
    if(head == end) {
      return null;
    }
    else if(head.next == end) {
      head.next = null;
      return head;
    }
    
    ListNode fast = head;
    ListNode slow = head;
    while(fast != end && fast.next != end) {
      fast = fast.next.next;
      slow = slow.next;
    }
    
    ListNode m1Beg = mergeSort(head, slow);
    ListNode m2Beg = mergeSort(slow, end);
    
    return merge(m1Beg, m2Beg);
  }

  private ListNode merge(ListNode m1Beg, ListNode m2Beg) {
    ListNode head = null;
    
    if (m1Beg != null && m2Beg != null) {
      if(m1Beg.val < m2Beg.val) {
        head = m1Beg;
        m1Beg = m1Beg.next;
      }
      else {
        head = m2Beg;
        m2Beg = m2Beg.next;
      }
    }
    else if(m2Beg != null) {
      head = m2Beg;
      m2Beg = m2Beg.next;
    }
    else if (m1Beg != null) {
      head = m1Beg;
      m1Beg = m1Beg.next;
    }
    
    ListNode m1 = m1Beg;
    ListNode m2 = m2Beg;
    ListNode itr = head;
    
    while(m1 != null && m2 != null) { 
      if (m1.val < m2.val) {
        itr.next = m1;
        itr = itr.next;
        m1 = m1.next;
      }
      else {
        itr.next = m2;
        itr = m2;
        m2 = m2.next;
      }
    }
    
    while(m2 != null) {
      itr.next = m2;
      m2 = m2.next;
      itr = itr.next;
    }
    
    while(m1 != null) {
      itr.next = m1;
      m1 = m1.next;
      itr = itr.next;
    }
    
    itr.next = null;
    
    return head;
    
  }
  
}
