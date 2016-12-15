package com.sort;

/**
 * Given an array with n objects colored red, white or blue, sort them 
 * so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
 * @author nraveend
 *
 */
public class SortColors {

  /**
   * i and n inclusive form the middle range 1
   * Use 3 indices, i, j and n.
   * j used for iteration.
   * increment i on swap smaller elements . All values below i(non inclusive) are  0.
   * All values above n(non inclusive) are  2.
   * decrement n on swap larger elements
   *         i     n 
   * 0 0 0 0 1 1 1 1 2 2 2 2
   * @param nums
   */
  public void sortColors(int[] nums) {
    
    int i = 0;
    int j = 0;
    int val =1;
    int n = nums.length - 1;
    
    while (j <= n) {
      if (nums[j] < val) {
        swap(nums, j, i);
        i++;
        j++;
      }
      else if (nums[j] > val) {
        swap(nums, j, n);
        n--;
      }
      else {
        j++;
      }
    }
  }

  private void swap(int[] nums, int j, int i) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;    
  }
  
}
