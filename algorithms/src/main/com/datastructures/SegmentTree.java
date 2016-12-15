package com.datastructures;

/**
 * SegementTree is used for oh(log(n)) for updates and querying range sums.
 * Stored in tree format. Sum for each interval is stored in each node.
 * Use recursion to build, query and update the tree
 * Use array for storing the tree. Size of array  2^(h+1) -1 . where h is the height
 * of the tree. h is log(n). n leaf nodes store original array. n-1 internal nodes store
 * the sum for the intervals.
 * Root of the tree has sum of all values in range.
 * Left node is 2 (i +1) - 1
 * Right node is 2 (i + 1)
 * Add the node if beg == end
 * else recursively add left and right nodes. 
 * Store the sum in current node as buildLeft + buildRight.
 * Use the same logic in update value.
 * Compute Logic
 * Return value if current range falls between required range
 * else recursively find value for left and right range add it.
 * @author nraveend
 *
 */
public class SegmentTree {

	private int[] seg ;
	private  final int arraySize;
	public SegmentTree(int arr[]) {
		arraySize = arr.length;
		int size = (int) (Math.pow(2, Math.ceil(Math.log(arr.length) /Math.log(2)) + 1) - 1);
		seg = new int[size];
		constructST(arr, 0, arr.length -1, 0);
	}
	
	/**
	 * 
	 * @param arr - Original array
	 * @param beg - Beginning of orig array
	 * @param end - end of original array
	 * @param segPos - Index in segment tree array
	 * @return
	 */
	private int constructST(int[] arr, int beg, int end, int segPos) {
		if(beg == end) {
			seg[segPos] = arr[beg];
			return arr[beg];
		}
		else if(beg < end) {
			int mid = beg + (end - beg) / 2;
			int left = constructST(arr, beg, mid, 2 * segPos + 1);
			int right = constructST(arr, mid + 1, end, 2 * segPos + 2);
			seg[segPos] = left + right;
			return seg[segPos] ;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Compute the sum between 2 ranges - inclusive.
	 * @param rBeg
	 * @param rEnd
	 * @return
	 */
	public int getSum(int rBeg, int rEnd) {
		return getSum(rBeg, rEnd, 0, 0, arraySize -1);
	}

	private int getSum(int rBeg, int rEnd, int segPos, int segBeg, int segEnd) {
		// outside range return 0;
		if ((rBeg < segBeg && rEnd  < segBeg) || (rBeg > segBeg &&  rBeg > segEnd)) {
			return 0;
		}
		// range inclusive
		else if( segBeg >= rBeg && segEnd <= rEnd) {
			return seg[segPos];
		}
		//Partial overlap
		else {
			int mid = segBeg + (segEnd - segBeg) / 2;
			return getSum(rBeg, rEnd, 2 * segPos + 1, segBeg, mid) +
					getSum(rBeg, rEnd, 2 * segPos + 2, mid + 1, segEnd);
		}
	}
	
	public void update(int pos, int value) {
		update(pos, value, 0, 0, arraySize - 1);
	}

	/**
	 * Update the value at position. Once change is made , percolate it upwards.
	 * @param pos
	 * @param value
	 * @param segPos
	 * @param segBeg
	 * @param segEnd
	 * @return
	 */
	private int update(int pos, int value, int segPos, int segBeg, int segEnd) {
		if (segBeg == segEnd && pos == segBeg) {
			int oldValue = seg[segPos];
			seg[segPos] = value;
			return value - oldValue;
		}
		else {
			int mid = segBeg + (segEnd - segBeg) / 2;
			if (pos <= mid) {
				int diff = update(pos, value, 2 * segPos + 1, segBeg, mid);
				seg[segPos] += diff;
				return diff;
			}
			else {
				int diff = update(pos, value, 2 * segPos + 2, mid + 1, segEnd);
				seg[segPos] += diff;
				return diff;
			}
		}
	}
}
