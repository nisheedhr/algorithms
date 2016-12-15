package com.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
 * @author nraveend
 *
 */
public class PlusOne {

	int [] plusOne(int[] digits) {
		int [] out = null;
		boolean extendArray = true;
		for(int i = 0 ; i < digits.length; ++i) {
			if(digits[i] != 9) {
				extendArray = false;
				break;
			}
		}
		if (extendArray) {
			out = new int[digits.length + 1];
			for(int i = 0 ; i < out.length; ++i) {
				out[i] = 0;
			}
			out[0] = 1;
		}
		else {
			out = new int[digits.length];
			int carry = 1;
			for(int i = digits.length - 1; i >= 0; --i) {
				int sum = digits[i] + carry;
				out[i] = sum % 10;
				carry = sum / 10;
			}
		}
		
		return out;
	}
}
