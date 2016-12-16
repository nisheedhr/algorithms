package com.topdown;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.topdown.NumBoomerangs;

public class NumBoomerangsTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testNumberOfBoomerangs() throws Exception {
    int[][] inpu = {{0,0},{1,0},{2,0}};
    assertEquals(2, new NumBoomerangs().numberOfBoomerangs(inpu));
  }

}
