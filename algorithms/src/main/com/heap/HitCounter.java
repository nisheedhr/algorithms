package com.heap;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class HitCounter {

  private static class Counter {
    public Counter(int timestamp, int i) {
      this.ts = timestamp;
      this.numHits = i;
    }

    int ts;
    int numHits;
  }

  private List<Counter> hitList = new LinkedList<>();
  private PriorityQueue<Integer> pq = new PriorityQueue<>();
  private int last5Hits = 0;

  /** Initialize your data structure here. */
  public HitCounter() {

  }

  /**
   *  use priority queue to record a hit
   * @param timestamp
   */
  public void hitNew(int timestamp) {
	  pq.offer(timestamp);
  }
  
  public int getHitsNew(int timestamp) {
	  while (!pq.isEmpty() && timestamp - pq.peek()  >= 300) {
		  pq.poll();
	  }
	  
	  return pq.size();
  }
  /**
   * Record a hit.
   * 
   * @param timestamp
   *          - The current timestamp (in seconds granularity).
   */
  public void hit(int timestamp) {
    last5Hits++;
    if (!hitList.isEmpty() && hitList.get(hitList.size() - 1).ts == timestamp) {
      hitList.get(hitList.size() - 1).numHits++;
    } else {
      hitList.add(new Counter(timestamp, 1));
    }
  }

  /**
   * Return the number of hits in the past 5 minutes.
   * 
   * @param timestamp
   *          - The current timestamp (in seconds granularity).
   */
  public int getHits(int timestamp) {
    int minVal = timestamp - 300;
    Iterator<Counter> iter = hitList.iterator();
    while (iter.hasNext()) {
      Counter cur = iter.next();
      if (cur.ts <= minVal) {
        iter.remove();
        last5Hits -= cur.numHits;
      } else {
        break;
      }
    }
    return last5Hits;
  }
}
