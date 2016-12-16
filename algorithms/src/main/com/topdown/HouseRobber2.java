package com.topdown;


/**
 * This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery 
so that he will not get too much attention. This time, all houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses 
remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
 * @author nraveend
 *
 */
public class HouseRobber2 {

	public int robNew(int[] nums){
		if (nums.length == 1) {
			return nums[nums.length - 1];
		}
		
		int prevPrev = 0;
		int prev = 0;
		
		// Find maximum including first element
		int max = 0;
		for (int i = 0; i < nums.length - 1; ++i) {
			int tmp = prev;
			if (nums[i] + prevPrev > prev) {
				prev = nums[i] + prevPrev;
			}
			prevPrev = tmp;
		}
		max = prev;
		
		//Find maximum excluding first element
		prevPrev = 0;
		prev = 0;
		for (int i = 1; i < nums.length; ++i) {
			int tmp = prev;
			if (nums[i] + prevPrev > prev) {
				prev = nums[i] + prevPrev;
			}
			prevPrev = tmp;
		}
		return Math.max(prev, max);
	}
	/**
	 * Key idea is , Say f(K) is maximum at house K. f(K) = MAX(f(K-2) +
	 * nums[k], f(K-1)) It should either have nums[0] or nums[1] in it. Make 2
	 * passes and return max(prev1, prev2) Use prevPrev for f(K-2)
	 * 
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
		
		if (nums.length == 1) {
			return nums[nums.length - 1];
		}
		int prevPrev = 0;
		int prev = 0;

		for (int i : nums) {
			int tmp = prev;
			prev = Math.max(i + prevPrev, prev);
			prevPrev = tmp;
		}

		int max = prevPrev;

		prevPrev = 0;
		prev = 0;

		for (int i = nums.length - 1; i >= 0; --i) {
			int tmp = prev;
			prev = Math.max(prevPrev + nums[i], prev);
			prevPrev = tmp;
		}

		return Math.max(max, prevPrev);
	}

	public int rob3(int[] nums) {
		int endSum[] = new int[2];
		int[] noEndSum = new int[2];

		if (nums.length == 0) {
			return 0;
		}

		endSum[0] = nums[nums.length - 1];

		for (int i = nums.length - 2; i >= 0; --i) {
			int tmp = Math.max(nums[i] + endSum[1], endSum[0]);
			endSum[1] = endSum[0];
			endSum[0] = tmp;

			tmp = Math.max(nums[i] + noEndSum[1], noEndSum[0]);
			noEndSum[1] = noEndSum[0];
			noEndSum[0] = tmp;
		}

		return Math.max(noEndSum[0], nums.length == 1 ? endSum[0] : endSum[1]);
	}

	private static class Result {
		int maxSum;
		int startIndex;
	};

	/**
	 * Key idea is to cache to sum from each point Need to compute sum
	 * recursively only for 2 adjacent houses after skipping next one.
	 * 
	 * @param nums
	 * @return
	 */
	public int rob2(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		} else if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		Result res = new Result();
		res.maxSum = 0;
		int sum[] = new int[nums.length];
		byte endIndex[] = new byte[nums.length];
		for (int i = 0; i < sum.length; ++i) {
			sum[i] = -1;
		}
		int curSum = 0;
		res.startIndex = 2;
		getMaxSum(nums, sum, endIndex, curSum, res, 2);
		res.startIndex = 1;
		getMaxSum(nums, sum, endIndex, curSum, res, 1);
		res.startIndex = 0;
		getMaxSum(nums, sum, endIndex, curSum, res, 0);
		return res.maxSum;
	}

	int getMaxSum(int[] nums, int[] sum, byte endIndex[], int curSum, Result res, int index) {
		if (index >= nums.length) {
			res.maxSum = Math.max(res.maxSum, curSum);
			return curSum;
		} else if (index == nums.length - 1) {
			sum[index] = nums[index];
			if (res.startIndex == 0 && index == nums.length - 1) {
				res.maxSum = Math.max(res.maxSum, curSum + sum[index] - Math.min(nums[nums.length - 1], nums[0]));
			} else {
				res.maxSum = Math.max(res.maxSum, curSum + sum[index]);
			}
			endIndex[index] = 1;
			return curSum + sum[index];
		} else if (sum[index] != -1) {
			if (res.startIndex == 0 && endIndex[index] == 1) {
				res.maxSum = Math.max(res.maxSum, curSum + sum[index] - Math.min(nums[nums.length - 1], nums[0]));
			} else {
				res.maxSum = Math.max(res.maxSum, curSum + sum[index]);
			}
			return curSum + sum[index];
		}

		int t1 = getMaxSum(nums, sum, endIndex, curSum + nums[index], res, index + 2);
		int t2 = getMaxSum(nums, sum, endIndex, curSum + nums[index], res, index + 3);
		sum[index] = Math.max(t1 - curSum, t2 - curSum);
		if (index + 2 < nums.length) {
			endIndex[index] = t1 > t2 ? endIndex[index + 2] : endIndex[index + 3];
		}
		return Math.max(t1, t2);
	}
}
