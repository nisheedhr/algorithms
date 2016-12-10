package com.datastructures;

/**
 *  use segment tree to find minimum value in a range
 * @author nraveend
 *
 */
public class SegmentTreeRangeMin {

	private final int arraySize;
	private int[] segTree ;

	public SegmentTreeRangeMin(int arr[]) {
		this.arraySize = arr.length ;
		int size = (int) (Math.pow(2, Math.ceil(Math.log(arraySize) / Math.log(2)) + 1) -1);
		segTree = new int[size];
		constructRangeMinSegTree(arr, 0, arraySize - 1, 0);
	}

	private int constructRangeMinSegTree(int[] arr, int beg, int end, int segPos) {
		if (beg == end) {
			segTree[segPos] = arr[beg];
			return segTree[segPos];
		}
		else if (beg < end) {
			int mid = beg + (end - beg)/ 2;
			int leftMin = constructRangeMinSegTree(arr, beg, mid, 2 * segPos + 1);
			int rightMin = constructRangeMinSegTree(arr, mid + 1, end, 2 * segPos + 2);
			segTree[segPos] = Math.min(leftMin, rightMin);
			return segTree[segPos];
		}
		return Integer.MAX_VALUE;
	}
	
	public int getMin(int rBeg, int rEnd) {
		return getMin(rBeg, rEnd, 0, arraySize -1, 0);
	}

	private int getMin(int rBeg, int rEnd, int segBeg, int segEnd, int segPos) {
		// Outside range
		if((rBeg < segBeg && rEnd < segBeg) || (rBeg > segBeg && rBeg > segEnd) )
		{
			return Integer.MAX_VALUE;
		}
		//inclusive range
		else if(segBeg >= rBeg && segEnd <= rEnd) {
			return segTree[segPos];
		}
		//partial 
		else  {
			int mid = segBeg + (segEnd - segBeg)/ 2;
			return Math.min(getMin(rBeg, rEnd, segBeg, mid, 2 * segPos + 1), 
					getMin(rBeg, rEnd, mid + 1 , segEnd, 2 * segPos + 2));
		}
	}
}
