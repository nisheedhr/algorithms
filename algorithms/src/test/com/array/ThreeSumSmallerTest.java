package com.array;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.array.ThreeSumSmaller;

public class ThreeSumSmallerTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testThreeSumSmaller() throws Exception {
    int[] arr = {1,1,-2};
    ThreeSumSmaller ts = new ThreeSumSmaller();
    assertEquals(0, ts.threeSumSmaller(arr, 0));
  }


}
