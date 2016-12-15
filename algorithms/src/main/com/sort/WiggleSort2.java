package com.sort;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
 * @author nraveend
 *
 */
public class WiggleSort2 {

  /**
   * Key idea is to find the median element.
   * Then place all large elements in odd positions
   * small elements in even position. Use an extra array for it.
   * 
   * Second option without using extra array.
   * core algorithm is similar to color sort.
   * It should have at least n/2 unique elements
   * @param nums
   */
  public void wiggleSort(int[] nums) {
    if(nums.length <= 1) {
      return;
    }
    int median = findKthLargest(nums, nums.length /2 );
    int left = 0; 
    int right = nums.length - 1;
    int i = 0;
    
    while(i <= right) {
      int newIndex = newIndex(i, nums.length);
      if(nums[newIndex] > median) {
        swap(nums, newIndex, newIndex(left, nums.length));
        left++;
        i++;
      }
      else if(nums[newIndex] < median) {
        swap(nums, newIndex, newIndex(right, nums.length));
        right--;
      }
      else {
        i++;
      }
    }
  }
  
  /**
   * Positions less than middle will translate to odd positions
   * Positions greater will translate to even positions.
   * @param i
   * @param length
   * @return
   */
  private int newIndex(int i, int length) {
    return (1 + 2 * i) %(length | 1);
  }

  public int findKthLargest(int[] arr, int k) {
    return findKth(arr, 0, arr.length -1 , k - 1);
  }

  private int findKth(int[] arr, int beg, int end, int k) {
    int part = partition(arr, beg, end);
    if(part == k) {
      return arr[k];
    }
    else if(part > k) {
      return findKth(arr, beg, part - 1, k);
    }
    else {
      return findKth(arr, part + 1, end, k);
    }
  }

  /**
   * Key idea is to initialize smallest to beg.
   * Do swap with smallest if you find larger element.
   * smallindex will point to begin of small array.
   * @param arr
   * @param beg
   * @param end
   * @return
   */
  private int partition(int[] arr, int beg, int end) {
    int val = arr[end];
    int smallIndx = beg;
    for(int i = beg; i < end ; ++i) {
      if (arr[i] > val) {
        swap(arr, i, smallIndx);
        smallIndx++;
      }
    }
    swap(arr, smallIndx, end);
    return smallIndx;
  }

  private void swap(int[] arr, int ind1, int ind2) {
   if (ind1 != ind2) {
     int tmp = arr[ind1];
     arr[ind1] = arr[ind2];
     arr[ind2] = tmp;
   }   
  }
}
