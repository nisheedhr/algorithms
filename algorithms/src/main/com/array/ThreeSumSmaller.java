package com.array;

import java.util.Arrays;

/**
 * Given an array of n integers nums and a target, find the number of index
 * triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] +
 * nums[j] + nums[k] < target.
 * 
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * 
 * Return 2. Because there are two triplets which sums are less than 2:
 * 
 * [-2, 0, 1] [-2, 0, 3] Follow up: Could you solve it in O(n2) runtime?
 * 
 * @author nraveend
 *
 */
public class ThreeSumSmaller {

  /**
   * Sort the array calculate 2 sum. binary search for pair in 
   * the original array from next position.
   * All earlier numbers are accounted for.
   * 
   * @param nums
   * @param target
   * @return
   */
  public int threeSumSmaller(int[] nums, int target) {

    if (nums == null || nums.length < 3) {
      return 0;
    }

    Arrays.sort(nums);
    int numTriplets = 0;

    int beg = 0;
    for (int i = 0; i < nums.length - 2; ++i) {
      for (int j = i + 1; j < nums.length; ++j) {
        int pair = target - (nums[i] + nums[j]);
        beg = j + 1;
        numTriplets += findNums(pair, beg, nums);
      }
    }

    return numTriplets;
  }

  private int findNums(int pair, int beg, int[] nums) {
    int start = beg;

    int end = nums.length - 1;
    while (beg <= end) {
      int mid = beg + (end - beg) / 2;
      if (nums[mid] >= pair) {
        end = mid - 1;

        if (end >= start && nums[end] < pair) {
          return end - start + 1;
        }
      } else {
        beg = mid + 1;
        if (beg == nums.length ) {
          return end - start + 1;
        }
      }
    }
    return 0;
  }

}
