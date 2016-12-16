package com.smart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.smart.PerfectRectnagle;

public class PerfectRectnagleTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testIsRectangleCover() throws Exception {
    
    int rectangles5[][] = {{0,0,4,1},{7,0,8,2},{6,2,8,3},{5,1,6,3},{4,0,5,1},
        {6,0,7,2},{4,2,5,3},{2,1,4,3},{0,1,2,2},{0,2,2,3},{4,1,5,2},{5,0,6,1}};
    assertEquals(true, new PerfectRectnagle().isRectangleCover(rectangles5));
    
    int rectangles[][] = {
        {1,1,3,3},
        {3,1,4,2},
        {3,2,4,4},
        {1,3,2,4},
        {2,3,3,4}
      };
    
    assertEquals(true, new PerfectRectnagle().isRectangleCover(rectangles));
    int rectangles2[][] = { {1,1,2,3}, {1,3,2,4}, {3,1,4,2}, {3,2,4,4} };
    assertEquals(false, new PerfectRectnagle().isRectangleCover(rectangles2));
    int rectangles3[][] = { {1,1,3,3}, {3,1,4,2}, {1,3,2,4}, {3,2,4,4} };
    assertEquals(false, new PerfectRectnagle().isRectangleCover(rectangles3));
    
    int rectangles4[][] = { {1,1,3,3}, {3,1,4,2}, {1,3,2,4}, {2,2,4,4} };
    assertEquals(false, new PerfectRectnagle().isRectangleCover(rectangles4));
    
    
    
    
    
    
  }

}
