package com.sort;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.sort.CountMergeSortSmallInteger;

public class CountMergeSortSmallIntegerTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testCountSmaller() throws Exception {
    int[] nums = {5, 2, 6, 1};
    System.out.println(Arrays.toString(new CountMergeSortSmallInteger().countSmaller(nums).toArray()));
  }


}
