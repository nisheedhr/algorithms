package com.topdown;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.topdown.HouseRobber1;

public class HouseRobber1Test {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testRob() throws Exception {
    int houses[] = {80, 20, 30, 40, 90, 100 };
    HouseRobber1 r1 = new HouseRobber1();
    assertEquals(220, r1.rob(houses));
    int houses2[] = {80};
    assertEquals(80, r1.rob(houses2));
    int houses3[] = {80, 160};
    assertEquals(160, r1.rob(houses3));
    int houses4[] = {180, 160};
    assertEquals(180, r1.rob(houses4));
    int houses5[] = {180, 1160, 110};
    assertEquals(1160, r1.rob(houses5));
  }
  
  @Test
  public void testRobNew() throws Exception {
    int houses[] = {80, 20, 30, 40, 90, 100 };
    HouseRobber1 r1 = new HouseRobber1();
    assertEquals(220, r1.robNew(houses));
    int houses2[] = {80};
    assertEquals(80, r1.robNew(houses2));
    int houses3[] = {80, 160};
    assertEquals(160, r1.robNew(houses3));
    int houses4[] = {180, 160};
    assertEquals(180, r1.robNew(houses4));
    int houses5[] = {180, 1160, 110};
    assertEquals(1160, r1.robNew(houses5));
  }

}
