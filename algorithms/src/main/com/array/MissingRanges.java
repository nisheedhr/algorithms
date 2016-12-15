package com.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are in the inclusive range [lower, upper],
 *  return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 * @author nraveend
 *
 */
public class MissingRanges {

	  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
	        List<String> result = new ArrayList<>();
	        int curExpected = lower;
	        boolean integerOveflow = false;
	        for(int i = 0 ; i < nums.length ; ++i) {
	        	if(nums[i] != curExpected) {
	        		result.add(buildMissingRange(curExpected, nums[i] -1));
	        	}
	        	// duplicates
	        	else if (nums[i] < curExpected) {
	        		continue;
	        	}
	        	curExpected = nums[i] + 1;
	        	if (curExpected > upper || nums[i] == Integer.MAX_VALUE) {
	        	    integerOveflow = true;
	        	    break;
	        	}
	        }
	        
	        if(curExpected <= upper && !integerOveflow) {
	        	result.add(buildMissingRange(curExpected, upper));
	        }
	        return result;
	    }
	    
	    private String buildMissingRange(int lower, int upper) {
	    	if(lower == upper) {
	    		return Integer.toString(lower);
	    	}
	    	else {
	    		StringBuilder sb = new StringBuilder();
	    		sb.append(lower);
	    		sb.append("->");
	    		sb.append(upper);
	    		return sb.toString();
	    	}
	    }
}
