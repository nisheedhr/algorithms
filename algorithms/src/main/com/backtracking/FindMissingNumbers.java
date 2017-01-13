package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
 * @author nisheedh
 *
 */
public class FindMissingNumbers {

	/**
	 * Iterate over array and mark all positions with numbers as 0.
	 * mark recursively marks all positions.
	 * In second iteration add positions to output which has non zero value.
	 * @param nums
	 * @return
	 */
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer> out = new ArrayList<>();
    	for (int i = 0; i < nums.length ; ++i) {
    		if (nums[i] != 0 ) {
    			mark(nums[i], nums);
    		}
    	}
    	
    	for (int i = 0; i < nums.length ; ++i) {
    		if (nums[i] != 0) {
    			out.add(i + 1);
    		}
    	}
    	return out;
    }

	private void mark(int val, int[] nums) {
		int pos = val - 1;
		if (nums[pos] != 0) {
			int old = nums[pos];
			nums[pos] = 0;
			mark(old, nums);
		}
		
	}
}
