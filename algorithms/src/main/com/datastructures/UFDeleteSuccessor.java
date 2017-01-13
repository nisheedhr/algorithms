package com.datastructures;

import java.util.Arrays;

/**
 * Note this problem is from the “Algorithm Part 1″ on Coursera. The detailed description is as follows:

Successor with delete. Given a set of N integers S={0,1,…,N−1} and a sequence of requests of the following form:

Remove x from S
Find the successor of x: the smallest y in S such that y >= x.
Design a data type so that all operations (except construction) should take logarithmic time or better.
 * @author nisheedh
 *
 */
public class UFDeleteSuccessor {

	int parentArr[];
	
	/**
	 * 
	 * @param arr
	 */
	public UFDeleteSuccessor(int arr[]) {
		parentArr = Arrays.copyOf(arr, arr.length);
	}
	
	public int root(int i) {
		if(i != parentArr[i]) {
			parentArr[i] = root(parentArr[i]);
		}
		return parentArr[i];
	}
	public void remove(int i) {
		
		union(i, i +1);
	}

	private void union(int i, int j) {
		parentArr[i] = root(j);
	}
	
	public int getSuccessor(int x) {
		return root(x);
	}
}
