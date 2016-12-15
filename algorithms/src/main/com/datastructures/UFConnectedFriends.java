package com.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * Social network connectivity. Given a social network containing n members and a log file containing m 
 * timestamps at which times pairs of members formed friendships, 
 * design an algorithm to determine the earliest time at which all members are connected 
 * (i.e., every member is a friend of a friend of a friend ... of a friend). 
 * Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. 
 * The running time of your algorithm should be mlogn or better and use extra space proportional to n.
 * @author nraveend
 *
 */
public class UFConnectedFriends {

	private int numFriends;
	private Map<Integer, Integer> parentMap = new HashMap<>();
	private Map<Integer, Integer> rankMap = new HashMap<>();
	private Map<Integer, Integer> maxMap = new HashMap<>();

	public UFConnectedFriends(int num) {
		this.numFriends = num;
		for (int i = 0; i < num ; ++i) {
			parentMap.put(i + 1,i + 1);
			maxMap.put(i +1,  i + 1);
			rankMap.put(i + 1,1);
		}
	}
	
	public UFConnectedFriends(int arr[]) {
		this.numFriends = arr.length;
		for (int i = 0; i < arr.length ; ++i) {
			parentMap.put(arr[i],arr[i]);
			maxMap.put(arr[i],  arr[i]);
			rankMap.put(arr[i],1);
		}
	}
	
	private int root(int id) {
		if (id != parentMap.get(id)) {
			parentMap.put(id, root(parentMap.get(id)));
		}
		return parentMap.get(id);
	}
	
	/**
	 * returns true if all friends are connected
	 * false if not.
	 * @param id1
	 * @param id2
	 * @return
	 */
	public boolean connectFriends(int id1, int id2) {
		return numFriends <= union(id1, id2);
	}
	
	public int getMax( int id1) {
		int parent = root(id1);
		return maxMap.get(parent);
	}
	
	int union(int id1, int id2) {
		int parent1 = root(id1);
		int parent2 = root(id2);
		int rank1 = rankMap.get(parent1);
		int rank2 = rankMap.get(parent2);
		if(rank2 < rank1) {
			parentMap.put(parent1, parent2);
			rankMap.put(parent2, rank1 + rank2);
			maxMap.put(parent2, Math.max(maxMap.get(parent1),  maxMap.get(parent2)));
		}
		else {
			parentMap.put(parent2, parent1);
			rankMap.put(parent1, rank1 + rank2);
			maxMap.put(parent1, Math.max(maxMap.get(parent1),  maxMap.get(parent2)));
		}
		return rank1 + rank2;
	}
}
