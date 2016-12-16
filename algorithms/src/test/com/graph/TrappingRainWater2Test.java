package com.graph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.graph.TrappingRainWater2;

public class TrappingRainWater2Test {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testTrapRainWater() throws Exception {
    int[][] input = {
        {1,4,3,1,3,2},
        {3,2,1,3,2,4},
        {2,3,3,2,3,1}
      };
    
    assertEquals(4, new TrappingRainWater2().trapRainWater(input));
  }


}
