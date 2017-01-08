package com.list;

import com.sort.QuickSortList.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 * @author nisheedh
 *
 */
public class ListIntersection {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    };

    /**
     * Compute the size of both lists.
     * Traverse the iter of bigger list, till both size are same.
     * Once the size are same, start comparing the lists. o(n) and o (1)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode inter = null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        int sizeA = getSize(nodeA);
        int sizeB = getSize(nodeB);
        
        while (sizeA > sizeB) {
            nodeA = nodeA.next;
            sizeA--;
        }
        
        while (sizeB > sizeA) {
            nodeB = nodeB.next;
            sizeB--;
        }
        
        while (nodeA != null && nodeB != null) {
            if (nodeA == nodeB) {
                inter = nodeA;
                break;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return inter;
    }

    private int getSize(ListNode nodeA) {
        int size = 0;
        while (nodeA != null) {
            size++;
            nodeA = nodeA.next;
        }
        return size;
    }

}
