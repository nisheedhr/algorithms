package com.topdown;

/**
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them 
 * is that adjacent houses have security system connected and it will automatically contact the police 
 * if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.
 * @author nraveend
 *
 */
public class HouseRobber1 {

  private static class Result {
    int maxSum;
  };
  
  /**
   * At any point maximum will be max of current + prePrev and previous.
   * Just use 2 variables for previous and previousPrevious.
   * @param nums
   * @return
   */
  public int robNew(int[] nums) {
	 int prev = 0;
	 int prevPrev = 0;
	 for (int i = 0; i < nums.length ; ++i) {
		 int tmp = prev;
		 if (prevPrev + nums[i] > prev) {
			 prev = prevPrev + nums[i];
		 }
		 prevPrev = tmp;
	 }
	 return prev;
  }
  /**
   * Key idea is to cache to sum from each point
   * Need to compute sum recursively only for  2 adjacent houses
   * after skipping next one.
   * @param nums
   * @return
   */
  public int rob(int[] nums) {
    Result res = new Result();
    res.maxSum = 0;
    int sum[] = new int[nums.length];
    for(int i = 0; i < sum.length ; ++i) {
      sum[i] = -1;
    }
    int curSum = 0;
    getMaxSum(nums, sum, curSum, res, 0);
    getMaxSum(nums, sum, curSum, res, 1);
    return res.maxSum;
  }

  int getMaxSum(int[] nums, int[] sum, int curSum, Result res, int index) {
    if (index >= nums.length) {
      return curSum;
    }
    else if (index == nums.length -1 || index == nums.length - 2) {
      sum[index] = nums[index];
      res.maxSum = Math.max(res.maxSum, curSum + sum[index]);
      return curSum + sum[index];
    }
    else if(sum[index] != -1) {
      res.maxSum = Math.max(res.maxSum, curSum + sum[index]);
      return curSum + sum[index];
    }
    
    int t1 = getMaxSum(nums, sum, curSum + nums[index], res, index + 2);
    int t2 = getMaxSum(nums, sum, curSum + nums[index], res, index + 3);
    sum[index] = Math.max(t1 - curSum, t2 - curSum);
    return Math.max(t1, t2);
  }
  
}
