package com.array;

import org.junit.Before;
import org.junit.Test;

import com.array.TwoSum;

public class TwoSumTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testSumList() throws Exception {
    int arr[] = { -6, -3, -4, -7, Integer.MIN_VALUE };
    TwoSum ts = new TwoSum();
    System.out.println(ts.sumList(arr, -10));
  }

}
