package com.datastructures;

import java.util.Arrays;

public class UFDeleteSuccessor {

	int parentArr[];
	
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
