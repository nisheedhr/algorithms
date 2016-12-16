package com.topdown;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.topdown.HouseRobber2;

public class HouseRobber2Test {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testRob() throws Exception {
    HouseRobber2 r1 = new HouseRobber2();
    int houses7[] = {1,1,3,6,7,10,7,1,8,5,9,1,4,4,3};
    assertEquals(41, r1.rob(houses7));
    int houses[] = {80, 20, 30, 40, 90, 100 };
    assertEquals(200, r1.rob(houses));
    int houses5[] = {180, 1160, 110};
    assertEquals(1160, r1.rob(houses5));
    int houses2[] = {80};
    assertEquals(80, r1.rob(houses2));
    int houses3[] = {80, 160};
    assertEquals(160, r1.rob(houses3));
    int houses4[] = {180, 160};
    assertEquals(180, r1.rob(houses4));
    int houses6[] = {6, 3, 10, 8, 2, 10, 3, 5, 10, 5, 3};
    assertEquals(36, r1.rob(houses6));
    int houses8[] = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
    assertEquals(16, r1.rob(houses8));
    int houses9[] = {94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72};
    assertEquals(2926, r1.rob(houses9));
    
    int houses88[] = {40, 90, 100};
    assertEquals(100, r1.rob(houses88));
    
    int house99[] = {1, 1, 1, 2};
    assertEquals(3, r1.rob(house99));
  }

}
