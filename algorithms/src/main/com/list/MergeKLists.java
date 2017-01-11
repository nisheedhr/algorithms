package com.list;

import java.util.PriorityQueue;

import com.list.MergeList.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * @author nisheedh
 *
 */
public class MergeKLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    };
    
    /**
     * Use a priority queue and merge the list
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        ListNode head = null;
        ListNode cur = null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val -b.val);
        
        for (ListNode node: lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        
        while (!pq.isEmpty()) {
            ListNode top = pq.poll();
            
            if (head == null) {
                head = top;
                cur = top;
                if (top.next != null) {
                    pq.offer(top.next);
                }
            } else {
                cur.next = top;
                cur = top;
                if (top.next != null) {
                    pq.offer(top.next);
                }
            }
        }
        
        if (cur != null) {
            cur.next = null;
        }
        return head;
    }
    
}
