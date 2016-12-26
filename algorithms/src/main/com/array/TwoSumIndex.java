package com.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 * @author nisheedh
 *
 */
public class TwoSumIndex {

	/**
	 * Use hash map to store num and list of indexes
	 * @param nums
	 * @param target
	 * @return
	 */
    public int[] twoSum(int[] nums, int target) {
    	int[] out = null;
        Map<Integer, Integer> lk = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
        	int num = nums[i];
        	int other = target - nums[i];
        	if (lk.containsKey(other)) {
        		out = new int[] {lk.get(other), i};
        		break;
        	}
        	lk.put(num, i);
        }
        return out;
    }
}
