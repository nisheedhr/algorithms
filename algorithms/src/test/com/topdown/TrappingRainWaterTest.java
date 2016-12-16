package com.topdown;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.topdown.TrappingRainWater;

public class TrappingRainWaterTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testTrap() throws Exception {
    int height22[] =  {4, 2, 0, 3, 2, 5};
    assertEquals(9, new TrappingRainWater().trap(height22));
    int height[] =  {0,1,0,2,1,0,1,3,2,1,2,1};
    assertEquals(6, new TrappingRainWater().trap(height));
    int height2[] =  {2, 0, 2};
    assertEquals(2, new TrappingRainWater().trap(height2));
  }
  
  @Test
  public void testTrapOptimal() throws Exception {
    int height22[] =  {4, 2, 0, 3, 2, 5};
    assertEquals(9, new TrappingRainWater().trapOptimal(height22));
    int height[] =  {0,1,0,2,1,0,1,3,2,1,2,1};
    assertEquals(6, new TrappingRainWater().trapOptimal(height));
    int height2[] =  {2, 0, 2};
    assertEquals(2, new TrappingRainWater().trapOptimal(height2));
  }

}
