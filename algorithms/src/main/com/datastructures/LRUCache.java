package com.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * @author nraveend
 *
 */

public class LRUCache {

	private static class Node {
		Node(int key, int value) {
			this.key = key;
			this.value = value;
			prev = null;
			next = null;
		}
		int value;
		Node prev;
		Node next;
		int  key;
	}
	
	private Node head = null;
	private Node tail = null;
	
	Map<Integer, Node> lookup = new HashMap<>();
	
	private final int capacity ; 
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(lookup.containsKey(key)) {
        	Node node = lookup.get(key);
        	removeNode(node);
        	addNode(node);
        	return node.value;
        }
        else {
        	return -1;
        }
    }
    
    private void addNode(Node node) {
		if(head == null) {
			head = node;
			tail = node;
		}
		else {
			tail.next = node;
			node.prev = tail;
			node.next = null;
			tail = node;
		}
		
	}

	private void removeNode(Node node) {
		if(node == head) {
			head = head.next;
			if(head != null) {
				head.prev = null;
			}
			if(node == tail) {
				tail = null;
			}
		} else {
			node.prev.next = node.next;
			if(node.next != null) {
				node.next.prev = node.prev;
			}
			else {
				tail = node.prev;
			}
		}
		
	}

	public void set(int key, int value) {
      
		if (lookup.containsKey(key)) {
			Node node = lookup.get(key);
			removeNode(node);
			addNode(node);
			node.value = value;
		} else {
			if (capacity == lookup.size()) {
				lookup.remove(head.key);
				removeNode(head);
			}
			Node node = new Node(key, value);
			lookup.put(key, node);
			addNode(node);
		}

	}
}
