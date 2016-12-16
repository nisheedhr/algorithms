package com.topdown;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. 
For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers 
given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * @author nraveend
 *
 */
public class SuperUglyNumber {

  /**
   * extend fromm NumUglyNumbers.
   * Find next value from min of previous values multipled by primes
   * @param n
   * @param primes
   * @return
   */
  public int nthSuperUglyNumber(int n, int[] primes) {
    List<Integer> table = new ArrayList<Integer>();
    table.add(1);
    int[] prevPrimeValPos = new int[primes.length];
    
    while (table.size() < n) {
      table.add(getNextVal(primes, prevPrimeValPos, table));
    }
    return table.get(table.size() -1);
  }

  private int getNextVal(int[] primes, int[] prevPrimeValPos, List<Integer> table ) {
    int minVal = Integer.MAX_VALUE;
    for (int i = 0; i < primes.length ; ++i) {
      int val = primes[i] * table.get(prevPrimeValPos[i]);
      if (val < minVal) {
        minVal = val;
      }
    }
    
    for (int i = 0; i < primes.length ; ++i) {
      if (minVal % primes[i] == 0) {
        prevPrimeValPos[i] += 1;
      }
    }
    
    return minVal;
  }
}
