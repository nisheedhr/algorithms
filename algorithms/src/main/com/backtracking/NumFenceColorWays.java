package com.backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * There is a fence with n posts, each post can be painted with one of the k
 * colors.
 * 
 * You have to paint all the posts such that no more than two adjacent fence
 * posts have the same color.
 * 
 * Return the total number of ways you can paint the fence.
 * 
 * Note: n and k are non-negative integers.
 * 
 * @author nisheedh
 *
 */
public class NumFenceColorWays {

	
	/**
	 * Use bottom up approach.With 2 spots and k colors
	 * numDifferentWays is k * k -1
	 * numSameWays(both spots with same color) is k.
	 * Then recursively add next post.
	 * Next post can be painted in k ways by adding to existing solution.
	 * numDifferentWays will be (numDifferentWays + numSameWays) * (k-1)
	 * numSameWays will be numDifferentWays.
	 * One set of numSameWays will get rejected as it will form three pairs
	 * @param n - Number of posts
	 * @param k- number of colors
	 * @return
	 */
	public int numWays(int n, int k) {
		if (n == 0 || k == 0 || (n > 2 && k == 1)) {
			return 0;
		} else if (n == 1) {
			return k ;
		} else {
			int numDifferentWays= k * (k -1);
			int numSameWays = k;
			for (int i = 2; i <n ; ++i) {
				int tmp = numDifferentWays;
				numDifferentWays = (numDifferentWays + numSameWays) * (k -1);
				numSameWays = tmp;
			}
			return numDifferentWays + numSameWays;
		}
		
	}

	/**
	 * Use RB to find all ways. Add a color if doesn't violate adjacent fence
	 * constraint.
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public int numWaysRB(int n, int k) {
		if (n == 0 || k == 0 || (n > 2 && k == 1)) {
			return 0;
		}
		int pos = 0;
		int[] arr = new int[n];
		arr[pos] = 1;
		return generateAllWays(arr, k, pos + 1) * k;
	}

	private int generateAllWays(int[] arr, int k, int pos) {
		if (pos == arr.length) {
			return 1;
		} 
		
		int res = 0;
		for (int col = 1; col <= k; ++col) {
			if (pos < 2 || (arr[pos - 1] != col || arr[pos - 2] != col)) {
				int oldCol = arr[pos];
				arr[pos] = col;
				int numWays = generateAllWays(arr, k, pos + 1);
				res += numWays;
				arr[pos] = oldCol;
			}
		}
		
		return res;

	}
}
