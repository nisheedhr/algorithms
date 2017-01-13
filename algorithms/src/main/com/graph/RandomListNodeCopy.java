package com.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null.

Return a deep copy of the list.
 * @author nisheedh
 *
 */
public class RandomListNodeCopy {

    private static class RandomListNode {
        int label;
        RandomListNode next;
        RandomListNode random;
        
        RandomListNode(int label) {
            this.label = label;
        }
    }
    
    /**
     * Driver loop should use list traversal to call copyNode and build the next link
     * copyNode should use DFS to copy each random node .
     * Use visited map to keep track of visited nodes.
     * copyNode should recursively build all random links.
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        Map<Integer, RandomListNode> visited = new HashMap<>();
        RandomListNode newHead = null;
        RandomListNode prev = null;
        
        RandomListNode node = head;
        while (node != null) {
            RandomListNode copy = copyNode(node, visited);
            if (newHead == null) {
                newHead = copy;
            }
            
            if (prev != null) {
                prev.next = copy;
            }
            prev = copy;
            node = node.next;
        }
        return newHead;
    }
    
    private RandomListNode copyNode(RandomListNode node, Map<Integer, RandomListNode> visited) {
        if (visited.containsKey(node.label)) {
            return visited.get(node.label);
        }
        
        RandomListNode copy = new RandomListNode(node.label);
        visited.put(copy.label, copy);
        if (node.random != null) {
            copy.random = copyNode(node.random, visited);
        }
        return copy;
    }
}
