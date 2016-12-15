package com.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.leetcode.Interval;

/**
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18]


 * @author nraveend
 *
 */
public class MergeIntervals {

	private static class Interval {
		private int start;
		private int end;
	}
	
	/**
	 * Sort -nlog(n) and then n. Overall nlog(n)
	 * @param intervals
	 * @return
	 */
	public List<Interval> merge(List<Interval> intervals) {

		if(intervals == null || intervals.size() <=1) {
			return intervals;
		}
		
		Collections.sort(intervals, (a, b) -> a.start - b.start);
		List<Interval> out = new ArrayList<>();
		Interval merge = intervals.get(0);
		
		for(int i = 1; i < intervals.size() ; ++i) {
			// no overlap
			if(intervals.get(i).start > merge.start && intervals.get(i).start > merge.end) {
				out.add(merge);
				merge = intervals.get(i);
			}
			else {
				merge.start = Math.min(merge.start, intervals.get(i).start);
				merge.end = Math.max(merge.end, intervals.get(i).end);
			}
		}
		out.add(merge);
		return out;
	}
}
