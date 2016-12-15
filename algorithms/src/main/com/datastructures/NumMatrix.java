package com.datastructures;

import java.util.Arrays;

import org.omg.CORBA.portable.ValueBase;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined 
 * by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by 
(row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.
 * @author nraveend
 *
 */
public class NumMatrix {

    private int[][] matrix;
    private int [][] origMatrix;

	public NumMatrix(int[][] matrix) {
        this.matrix = new int[matrix.length][];
        this.origMatrix = new int[matrix.length][];
        for(int row = 0; row< matrix.length ; ++ row) {
        	this.matrix[row] = new int[matrix[row].length];
        	this.origMatrix[row] = Arrays.copyOf(matrix[row], matrix[row].length);
        	
        }
        
        for(int i = 0; i < matrix.length; ++i) {
        	for(int j = 0; j < matrix[i].length ; ++j) {
        		updateImpl(i, j, matrix[i][j]);
        	}
        }
    }

	public void update(int row, int col, int val) {
		int oldVal = origMatrix[row][col];
		origMatrix[row][col]  = val;
		updateImpl(row, col, val - oldVal);
	}
	
    private void updateImpl(int row, int col, int val) {
        row = row + 1;
        col = col + 1;
        for (; row <= matrix.length ; row += row & -row) {
        	for(int colIndex = col ; colIndex <= matrix[row -1].length ; colIndex += colIndex & -colIndex) {
        		matrix[row - 1][colIndex -1] += val;
        	}
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
    	return getSum(row2, col2) - getSum(row1 -1, col2) - getSum(row2, col1 -1) + getSum(row1 -1, col1 -1);
    }

	private int getSum(int row, int col) {
		int sum = 0;
		row = row + 1;
		col = col + 1;
		for (; row > 0; row -= row & -row) {
			for (int colIndex = col; colIndex > 0; colIndex -= colIndex & -colIndex) {
				sum += matrix[row - 1][colIndex - 1];
			}
		}
		return sum;
	}
}
