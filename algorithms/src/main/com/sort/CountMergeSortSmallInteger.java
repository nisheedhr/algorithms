package com.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts
 * array. The counts array has the property where counts[i] is the number of
 * smaller elements to the right of nums[i].
 * 
 * Example:
 * 
 * Given nums = [5, 2, 6, 1]
 * 
 * To the right of 5 there are 2 smaller elements (2 and 1). To the right of 2
 * there is only 1 smaller element (1). To the right of 6 there is 1 smaller
 * element (1). To the right of 1 there is 0 smaller element. Return the array
 * [2, 1, 1, 0].
 * 
 * @author nraveend
 *
 */
public class CountMergeSortSmallInteger {

	/**
	 * Use merge sort to count number of small integers.
	 * Maintain an indices array and sort it based on actual value array.
	 * @param nums
	 * @return
	 */
	public List<Integer> countSmaller(int[] nums) {
		int[] tmp = new int[nums.length];
		int[] counters = new int[nums.length];
		int[] indices = new int[nums.length];
		int beg = 0;
		int end = nums.length - 1;
		for (int i = 0; i < nums.length; ++i) {
			indices[i] = i;
		}
		mergeSort(indices, tmp, nums, counters, beg, end);
		List<Integer> res = new ArrayList<>();
		for (int val : counters) {
			res.add(val);
		}

		return res;
	}

	private void mergeSort(int[] indices, int[] tmp, int[] nums, int[] counters, int beg, int end) {
		if (beg < end) {
			int mid = beg + (end - beg) / 2;
			mergeSort(indices, tmp, nums, counters, beg, mid);
			mergeSort(indices, tmp, nums, counters, mid + 1, end);
			merge(indices, tmp, nums, counters, beg, mid, end);
		}

	}

	private void merge(int[] indices, int[] tmp, int[] nums, int[] counters, int beg, int mid, int end) {
		for (int i = beg; i <= end; ++i) {
			tmp[i] = indices[i];
		}

		int left = beg;
		int right = mid + 1;
		int target = beg;

		int numMovedLeft = 0;
		while (left <= mid && right <= end) {
			if (nums[tmp[left]] <= nums[tmp[right]]) {
				indices[target++] = tmp[left];
				counters[tmp[left]] += numMovedLeft;
				left++;
			} else {
				indices[target++] = tmp[right];
				right++;
				numMovedLeft++;
			}
		}

		while (left <= mid) {
			indices[target++] = tmp[left];
			counters[tmp[left]] += numMovedLeft;
			left++;
		}

		while (right <= end) {
			indices[target++] = tmp[right];
			right++;
		}

	}
}
