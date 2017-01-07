package com.bsearch;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 * @author nisheedh
 *
 */
public class TwoDimMatrixBinSearch {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        
        int row = findRow(matrix, target);
        int arr[] = matrix[row];
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return false;
    }

    private int findRow(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        int rowLen = matrix[0].length;
        while (low < high) {
            int mid = (low + high)/ 2;
            if (target > matrix[mid][rowLen -1]) {
                low = mid + 1;
            } else if (target  < matrix[mid][0]) {
                high = mid -1;
            } else {
                return mid;
            }
        }
        return low;
    }
    
}
