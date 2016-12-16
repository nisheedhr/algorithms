package com.heap;

import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value.
 *  So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

add(1)
add(2)
findMedian() -> 1.5
add(3) 
findMedian() -> 2
 * @author nraveend
 *
 */
public class MedianFinder {

  private PriorityQueue<Integer> largeHeap = new PriorityQueue<>();
  private PriorityQueue<Integer> smallheap = new PriorityQueue<>((a,b) -> b - a);
  // Adds a number into the data structure.
  public void addNum(int num) {
      if (largeHeap.isEmpty()) {
        largeHeap.offer(num);
      } else if (num > largeHeap.peek()) {
        largeHeap.offer(num);
        if (largeHeap.size() > smallheap.size()) {
          smallheap.offer(largeHeap.poll());
        }
      } else {
        smallheap.offer(num);
        if (smallheap.size() > largeHeap.size()) {
          largeHeap.offer(smallheap.poll());
        }
      }
  }

  // Returns the median of current data stream
  public double findMedian() {
      if (largeHeap.size() > smallheap.size()) {
        return largeHeap.peek();
      } else if (smallheap.size() > largeHeap.size()) {
        return smallheap.peek();
      } else {
        return (largeHeap.peek() + smallheap.peek()) / 2.0 ;
      }
  }
}
