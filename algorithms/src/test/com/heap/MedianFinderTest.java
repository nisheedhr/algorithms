package com.heap;

import static org.junit.Assert.*;

import java.util.PriorityQueue;

import org.junit.Before;
import org.junit.Test;

public class MedianFinderTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testAddNum() throws Exception {
    PriorityQueue<Integer> largeHeap = new PriorityQueue<>();
    largeHeap.add(-2);
    largeHeap.add(-1);
    assertEquals(-2, largeHeap.peek().intValue());
  }

  @Test
  public void testFindMedian() throws Exception {
   
  }

}
