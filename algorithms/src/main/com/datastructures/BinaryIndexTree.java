package com.datastructures;


/**
 * Other name Fenwick tree. Similar to Segment tree. Stores sums at intervals.
 * More space efficient.
 * Stores sums at powers of two indexes.
 * 
 * Sum - Add only right links.
 * Update - only left links
 * 
 * least significant bit (LSB) i & -i
 * index to root using right link i - lsb(i);
 * index to root using left links i + lsb(i)
 * @author nraveend
 *
 */
public class BinaryIndexTree {

	private int[] bit;

	public BinaryIndexTree(int arr[]) {
		this.bit = new int[arr.length];
		for(int i = 0; i < arr.length ; ++i) {
			update(i, arr[i]);
		}
	}

	/**
	 * update all positions from index to root
	 * where you take left path. root is at end of bit array and contains sum of entire
	 * array
	 * @param index
	 * @param value
	 */
	public void update(int index, int value) {
		index = index + 1; // use 1 based index
		while (index <= bit.length) {
			bit[index -1] += value;
			index += (index & -index);
		}
		
	}
	
	/**
	 * Add sum of only left links from the index to position 0
	 * @param index
	 * @return
	 */
	public int getSum(int index) {
		index = index +1;
		int sum = 0;
		while (index > 0) {
			sum += bit[index -1];
			index -= (index & -index);
		}
		return sum;
	}
	
	public int getSum(int beg, int end) {
		int bSum = getSum(beg -1);
		int endSum = getSum(end);
		return endSum - bSum;
	}
	
}
