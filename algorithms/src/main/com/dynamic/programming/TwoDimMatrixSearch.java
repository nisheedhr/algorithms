package com.dynamic.programming;

/**
 * Matrix has values sorted in rows and columns in ascending order.
 * Search for an element.
 * [
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
 * @author nisheedh
 *
 */
public class TwoDimMatrixSearch {

    /**
     * Begin search from top right corner.
     * If value greater than current cell eliminate current row
     * else if value less eliminate current column.
     * else if value equals return value.
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        
        int row = 0;
        int col = matrix[0].length - 1;
        
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (target > matrix[row][col]) {
                row = row +1;
            } else {
                col = col -1;
            }
        }
        return false;
    }
    
}
