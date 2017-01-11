package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique 
 * triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 * @author nisheedh
 *
 */
public class ThreeSumNew {

    /**
     * Sort the array.
     * Compute 2 sum and look for 3rd elements. O(n^2 logn)
     * Check for dups before adding to the array.
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>  out = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -2 ; ++i) {
           
            if(i == 0 || i > 0 && nums[i] != nums[i-1]) {
                int low = i + 1; int hi = nums.length -1;
                int sum = 0 - nums[i];
                
                while (low < hi) {
                    if (nums[low] + nums[hi] == sum) {
                        List<Integer> pairs = new ArrayList<>();
                        pairs.add(nums[i]);
                        pairs.add(nums[low]);
                        pairs.add(nums[hi]);
                        out.add(pairs);
                        while (low < hi && nums[low] == nums[low +1]) {
                                low++;
                        }
                        
                        while (low < hi && nums[hi] == nums[hi-1]) {
                            hi--;
                        }
                        low++;
                        hi--;
                    } else if (nums[low] + nums[hi] < sum) {
                        low++;
                    }
                    else {
                        hi--;
                    }
                }
            }
        }
        return out;
    }
}
