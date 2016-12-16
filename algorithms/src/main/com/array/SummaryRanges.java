package com.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * @author nraveend
 *
 */
public class SummaryRanges {

  private static class Range {
    int low;
    int high;
    public String toString() {
      if (low == high) {
        return Integer.toString(low);
      } else {
        return Integer.toString(low) + "->" + Integer.toString(high);
      }
    }
  }
  /**
   * Simple iteration over loop and add add range to output at beginning of new range
   * @param nums
   * @return
   */
  public List<String> summaryRanges(int[] nums) {
    List<String> out = new ArrayList<>();
    Range cur = new Range();
    if (nums.length == 0) {
      return out;
    }
    
    for (int i = 0; i < nums.length ; ++i) {
      if (i == 0) {
        cur.low = nums[i];
        cur.high = nums[i];
      } else if (nums[i] == cur.high + 1) {
        cur.high = nums[i];
      } else {
        out.add(cur.toString());
        cur.low = nums[i];
        cur.high = nums[i];
      }
    }
    out.add(cur.toString());
    return out;
  }
}
