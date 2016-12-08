package com.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Design a data structure that supports all following operations in average
 * O(1) time.
 * 
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present. getRandom: Returns
 * a random element from current set of elements. Each element must have the
 * same probability of being returned. Example:
 * 
 * // Init an empty set. RandomizedSet randomSet = new RandomizedSet();
 * 
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * 
 * // Returns false as 2 does not exist in the set. randomSet.remove(2);
 * 
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * 
 * // getRandom should return either 1 or 2 randomly. randomSet.getRandom();
 * 
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * 
 * // 2 was already in the set, so return false. randomSet.insert(2);
 * 
 * // Since 1 is the only number in the set, getRandom always return 1.
 * randomSet.getRandom();
 * 
 * @author nisheedh
 *
 */
public class RandomizedSet {

	/**
	 * Key idea - Use abs for negative values after doing mod to find bucket position.
	 * Use Node wrapper around List of values; Rest of the code follow.s
	 * @author nisheedh
	 *
	 */
	private static class Node {
		List<Integer> vals;

		Node(Integer val) {
			vals = new ArrayList<>();
			vals.add(val);
		}
	}

	private int capacity = 100;
	private Node[] buckets = new Node[capacity];
	private Random rand = new Random();
	List<Integer> posList = new ArrayList<>();

	/** Initialize your data structure here. */
	public RandomizedSet() {

	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		int pos = Math.abs(Integer.hashCode(val) % capacity);
		if (buckets[pos] == null) {
			Node node = new Node(val);
			buckets[pos] = node;
			posList.add(pos);
		} else {
			Node tmp = buckets[pos];
			if (!tmp.vals.contains(val)) {
				tmp.vals.add(val);
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		int pos = Math.abs(Integer.hashCode(val) % capacity);
		if (buckets[pos] == null) {
			return false;
		} else {
			Node tmp = buckets[pos];
			return tmp.vals.remove(new Integer(val));
		}
	}

	/** Get a random element from the set. */
	public int getRandom() {
		int pos = rand.nextInt(posList.size());
		while (buckets[posList.get(pos)] == null|| buckets[posList.get(pos)].vals.isEmpty()) {
			posList.remove(pos);
			pos = rand.nextInt(posList.size());
		}

		Node tmp = buckets[posList.get(pos)];
		int lpos = rand.nextInt(tmp.vals.size());
		return tmp.vals.get(lpos);
	}
}
