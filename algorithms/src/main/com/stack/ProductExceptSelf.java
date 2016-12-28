package com.stack;

/**
 * Given an array of n integers where n > 1, nums, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * Follow up: Could you solve it with constant space complexity? (Note: The
 * output array does not count as extra space for the purpose of space
 * complexity analysis.)
 * 
 * Show Company Tags Show Tags Show Similar Problems
 * 
 * @author nisheedh
 *
 */
public class ProductExceptSelf {

    /**
     * Use 2 pass of the array from left to right and right to left Left to
     * right will compute proudct from left. During right to left it will
     * compute product from right. Multiply it by value from first pass will
     * produce desired output
     * 
     * @param out
     * @param nums
     * @param prev
     * @param pos
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int out[] = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            if (i != 0) {
                out[i] = out[i - 1] * nums[i - 1];
            } else {
                out[i] = 1;
            }
        }

        int curProd = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; --i) {
            if (i != nums.length - 1) {
                out[i] = out[i] * curProd;
                curProd = curProd * nums[i];
            }
        }
        return out;
    }

}
