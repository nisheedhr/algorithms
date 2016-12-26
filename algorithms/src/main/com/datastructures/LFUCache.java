package com.datastructures;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. set(key, value) - Set or insert the
 * value if the key is not already present. When the cache reaches its capacity,
 * it should invalidate the least frequently used item before inserting a new
 * item. For the purpose of this problem, when there is a tie (i.e., two or more
 * keys that have the same frequency), the least recently used key would be
 * evicted.
 * 
 * Follow up: Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * LFUCache cache = new LFUCache( );
 * 
 * cache.set(1, 1); cache.set(2, 2); cache.get(1); // returns 1 cache.set(3, 3);
 * // evicts key 2 cache.get(2); // returns -1 (not found) cache.get(3); //
 * returns 3. cache.set(4, 4); // evicts key 1. cache.get(1); // returns -1 (not
 * found) cache.get(3); // returns 3 cache.get(4); // returns 4
 * 
 * @author nisheedh
 *
 */
public class LFUCache {

    /**
     * Use 2 maps. One for key to value. Another for key to node. Node contains
     * list of keys with the same number of access. Node list should use
     * LinkedHashSet which maintains insertion order. Helps in removing oldest
     * item in case of a tie
     * 
     * @param capacity
     */
    private static class Node {
        private int count;
        private LinkedHashSet<Integer> keys = new LinkedHashSet<>();
        private Node prev = null;
        private Node next = null;

        Node(int key, int count) {
            this.count = count;
            this.keys.add(key);
        }
    }

    private final int capacity;
    private Map<Integer, Integer> valueMap = new HashMap<>();
    private Map<Integer, Node> nodeMap = new HashMap<>();
    private Node head = null;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (valueMap.containsKey(key)) {
            increaseKeyAccessCount(key);
            return valueMap.get(key);
        }
        return -1;
    }

    private void increaseKeyAccessCount(int key) {
        Node node = nodeMap.get(key);
        node.keys.remove(key);

        if (node.next == null) {
            Node next = new Node(key, node.count + 1);
            nodeMap.put(key, next);
            next.prev = node;
            node.next = next;
            // Insert next element
        } else if (node.next.count != node.count + 1) {
            Node next = new Node(key, node.count + 1);
            nodeMap.put(key, next);
            next.prev = node;
            next.next = node.next;
            node.next.prev = next;
            node.next = next;
        } else {
            node.next.keys.add(key);
            nodeMap.put(key, node.next);
        }

        if (node.keys.size() == 0) {
            // head node
            if (node.prev == null) {
                head = node.next;
                head.prev = null;
                node.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.prev = null;
                node.next = null;
            }
        }
    }

    public void set(int key, int value) {
        if (capacity < 1) {
            return;
        }
        if (valueMap.containsKey(key)) {
            valueMap.put(key, value);
        } else {
            if (capacity == valueMap.size()) {
                removeOldest();
            }
            valueMap.put(key, value);
            addNodeToFront(key);
        }
        increaseKeyAccessCount(key);
    }

    private void addNodeToFront(int key) {
        if (head == null) {
            Node node = new Node(key, 0);
            nodeMap.put(key, node);
            head = node;
        } else {
            Node node = new Node(key, 0);
            nodeMap.put(key, node);
            head.prev = node;
            node.next = head;
            head = node;
        }

    }

    private void removeOldest() {
        int key = head.keys.iterator().next();
        head.keys.remove(key);
        nodeMap.remove(key);
        valueMap.remove(key);
        if (head.keys.size() == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        }
    }
}
