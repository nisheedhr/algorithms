package com.bsearch;

/**
 * Increasing sequence of numbers followed by decreasing sequence of numbers
 * 
 * 1 3 4 7 9 6 5 2 0
 * 
 * Find if an element exists in the array
 * @author nraveend
 *
 */
public class BiotonicArray {

	/**
	 * Use modified version of binary search.
	 * Check in left if value less than mid.
	 * If value greater than mid or (value not found and end value less than val, check again)
	 * @param arr
	 * @param val
	 * @return
	 */
	int getIndex(int arr[], int val) {
		int beg = 0;
		int end = arr.length -1 ;
		return binSearch( arr, beg, end, val);
	}

	private int binSearch(int[] arr, int beg, int end, int val) {
		if( beg <= end) {
			int mid = beg + (end -beg)/2 ;
			if(arr[mid] == val) {
				return mid;
			}
			
			int index = -1;
			if(val < arr[mid] ) {
				index = binSearch(arr, beg, mid -1, val);
			}
			
			if(val > arr[mid] || index == -1 && arr[end] < val) {
				index = binSearch(arr, mid + 1, end, val);
			}
			return index;
		}
		else {
			return -1;
		}
	}
}
