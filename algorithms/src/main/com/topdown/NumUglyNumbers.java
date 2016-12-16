package com.topdown;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 
is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.
 * @author nraveend
 *
 */
public class NumUglyNumbers {

  /**
   * These numbers are some multiple of  2^twoPos * 3 ^threePos * 5 ^fivePos.
   * Next number can be computed from previous ugly number
   * by multiplying by 2 or 3 or 5. Then pick min value.
   * Increment twoPos , threePos and fivePos if the next value is multiple of 2, 3 and 5.
   * 
   * @param n
   * @return
   */
  public int nthUglyNumber(int n) {
    int twoPos = 0; // position in the list for the nth entry
    int threePos = 0;
    int fivePos = 0;
    
    List<Integer> table = new ArrayList<>();
    table.add(1);
    
    while (table.size() < n) {
      int next_val = Math.min( 2 * table.get(twoPos),  Math.min(3 * table.get(threePos), 5 * table.get(fivePos)));
      table.add(next_val);
      
      if (next_val / table.get(twoPos) == 2) {
        twoPos++;
      }
      
      if (next_val / table.get(threePos) == 3) {
        threePos++;
      }
      
      if (next_val / table.get(fivePos) == 5) {
        fivePos++;
      }
    }
    
    return table.get(table.size() -1);
  }
}
