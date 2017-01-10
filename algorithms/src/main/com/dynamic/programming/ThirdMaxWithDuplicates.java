package com.dynamic.programming;

/**
 * Given a non-empty array of integers, return the third maximum number in this array. If it 
 * does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
 * @author nisheedh
 *
 */
public class ThirdMaxWithDuplicates {

    /**
     * Use 3 variables for max three elements and a variable for number of unique
     * elements
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        int count = 0;
        Integer small, mid , max;
        small = mid = max= null;
        
        for (int x: nums) {
            if ((max != null && x == max) || (mid != null && x == mid)) {
                continue;
            } else if (max == null || x > max) {
                small = mid;
                mid = max;
                max = x;
                count ++;
            } else if (mid == null || x > mid) {
                small = mid;
                mid = x;
                count++;
            } else if (small == null || x > small) {
                small = x;
                count++;
            } else if ( small != null && x < small) {
                count++;
            }
        }
        return (count >= 3 ? small: max);
    }
}
