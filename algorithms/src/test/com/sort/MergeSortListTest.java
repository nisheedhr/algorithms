package com.sort;

import org.junit.Before;
import org.junit.Test;

import com.sort.MergeSortList;
import com.sort.MergeSortList.ListNode;

public class MergeSortListTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testSortList() throws Exception {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(4);
    node1.next = node2;
    ListNode node3 = new ListNode(6);
    node2.next = node3;
    ListNode node4 = new ListNode(2);
    node3.next = node4;
    ListNode node5 = new ListNode(3);
    node4.next = node5;
    ListNode node6 = new ListNode(5);
    node5.next = node6;
    
    MergeSortList ms = new MergeSortList();
    node1 = ms.sortList(node1);
    
    ListNode node11 = new ListNode(2);
    ListNode node22 = new ListNode(1);
    node11.next = node22;
    node11 = ms.sortList(node11);
    
  }

}
