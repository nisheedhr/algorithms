package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	/**
	 * n^2 logn . Can use hash map to compute and store 2 sums. then lookup in oh no loop.
	 * @param arr
	 * @param sum
	 * @return
	 */
	public List<List<Integer>> get3Sum(int[] arr, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(arr);
		for(int i = 0; i <arr.length; ++i) {
			for(int j = i + 1; j < arr.length; ++j) {
				int curSum = arr[i] + arr[j];
				int beg = 0;
				int end = arr.length -1;
				while(beg <= end) {
					int mid = beg + (end - beg) / 2;
					if(sum -curSum > arr[mid]) {
						beg = mid +1;
					}
					else if (sum -curSum < arr[mid]) {
						end = mid -1 ;
					}
					else {
						List<Integer> list = new ArrayList<>();
						list.add(i);
						list.add(j);
						list.add(mid);
						result.add(list);
						break;
					}
				}
			}
		}
		return result;
	}
}
