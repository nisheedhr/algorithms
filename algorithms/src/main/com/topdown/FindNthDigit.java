package com.topdown;

/**
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8,
 * 9, 10, 11, ...
 * 
 * Note: n is positive and will fit within the range of a 32-bit signed integer
 * (n < 2^31).
 * 
 * Example 1:
 * 
 * Input: 3
 * 
 * Output: 3 Example 2:
 * 
 * Input: 11
 * 
 * Output: 0
 * 
 * Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
 * 11, ... is a 0, which is part of the number 10.
 * 
 * @author nraveend
 *
 */
public class FindNthDigit {

  /**
   * Key idea is digits will be like 9 *1 + 90 * 2 + 900 *3 and so on. Find the
   * number for nth digit and return the digit. Number can be found by
   * iteratively subtracting 9 * pow(10,numdigits) * numDigits. If exact match,
   * return last digit. Else return the correct digit of next number.
   * Find (num / 10 ^(curDigits - remDigits)) mod 10 .
   * 
   * @param n
   * @return
   */
  public int findNthDigit(int n) {
    int curDigits = 1;
    int curFactor = 9;

    int num = 0;
    while (n > curFactor * curDigits) {
      num += curFactor;
      n = n - curFactor * curDigits;
      curDigits++;
      curFactor *= 10;
      if (curFactor * curDigits < 0) {
        break;
      }
    }

    num += n / curDigits;

    int remDigits = n % curDigits;
    if (remDigits == 0) {
      return num % 10;
    } else {
      num += 1;
      int digit = ((int) (num / Math.pow(10, curDigits - remDigits))) % 10;
      return digit;
    }

  }
}
