package com.topdown;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) 
 * which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

 * @author nraveend
 *
 */
public class PerfectSquares {

  /**
   * Start from sqaure root of n till 4 find min squares.
   * and get the min value
   * @param n
   * @return
   */
  public int numSquares(int n) {
    int min = n;
    int max = (int) Math.sqrt(n);
    for (int i = max * max; i >= 4;) {
      int cur = n / i;
      if (cur >= min) {
        break;
      }
      int rem = n % i;
      int curVal = cur + (rem != 0 ? numSquares(rem) :0);
      
      if (curVal < min) {
        min = curVal;
      }
      
      i = (int) Math.pow(Math.sqrt(i) - 1, 2);
    }
    return min;
  }
}
