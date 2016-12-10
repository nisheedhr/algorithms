package com.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 * 
 * For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 * 
 * @author nisheedh
 *
 */
public class MinMeetingRooms {

	private static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	};

	/**
	 * Key idea 
	 * Sort the array by min start time and min end time. Shorter tasks will get scheduled first.
	 * Create a heap of min end time. Push entries into heap. If start tim of entry is later than top of heap
	 * don't increment num meeting room else else increment meeting room.
	 * @param intervals
	 * @return
	 */
	public int minMeetingRooms(Interval[] intervals) {
		int min = 0;
		Arrays.sort(intervals, ((p, q) -> (p.start != q.start)? p.start - q.start : p.end - q.end ));
		PriorityQueue<Interval> pq = new PriorityQueue<>((p, q) -> p.end - q.end);
		for (Interval intvl: intervals) {
			if (pq.isEmpty()) {
				min++;
				pq.offer(intvl);
			} else if (pq.peek().end <= intvl.start) {
				pq.poll();
				pq.offer(intvl);
			} else {
				min++;
				pq.offer(intvl);
			}
		}
		return min;
	}
}
