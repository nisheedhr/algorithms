package com.datastructures;

import java.util.Arrays;

/**
 * Extend the concept of 1-d bit array to 2 dimensional
 * do update and getSum in both directions.
 * For getSum of rectangle, use combination of multiple rectangles
 * subtract 3 and add one. use x-1, y -1
 * complexity of building is NM(log(NM))
 * Update and getSum is log(NM)
 * @author nraveend
 *
 */
public class BinaryIndexTree2D {

	private int[][] bit;

	/**
	 * IT EXPECTS UPDATE FUNCTION TO SEND DIFF VALUE I.E OLD VAL - NEW VAL
	 * Implementation in NumMatrix is correct one where it COMPUTES the new value
	 * from the old value.
	 * @param arr
	 */
	public BinaryIndexTree2D(int arr[][]) {
		this.bit = new int[arr.length][arr[0].length];
		
		for(int x = 0; x < arr.length; ++x) {
			for(int y = 0; y < arr[x].length ; ++y) {
				update(x, y, arr[x][y]);
			}
		}
		for (int[] out: bit) {
			System.out.println(Arrays.toString(out));
		}
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param value
	 */
	public void update(int x, int y, int value) {
		x = x + 1;
		y = y + 1;
		for(; x <= bit.length ; x += x & -x) {
			for(int col = y ; col <= bit[x-1].length ;col += col & -col) {
				bit[x-1][col-1] += value;
			}
		}
	}
	
	public int getSum(int x, int y) {
		x = x + 1;
		y = y + 1;
		int sum = 0 ;
		for(; x > 0 ; x -= x & -x) {
			for(int col = y; col > 0 ; col -= col & -col) {
				sum += bit[x-1][col-1];
			}
		}
		return sum;				
	}
	
	public int getSum(int x1, int y1, int x2, int y2) {
		return getSum(x2,y2) - getSum(x2, y1-1) - getSum(x1-1, y2) + getSum(x1 -1, y1-1);
	}
}
