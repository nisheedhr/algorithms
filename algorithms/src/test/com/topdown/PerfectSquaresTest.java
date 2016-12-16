package com.topdown;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.topdown.PerfectSquares;

public class PerfectSquaresTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testNumSquares() throws Exception {
    assertEquals(3, new PerfectSquares().numSquares(12));
    assertEquals(2, new PerfectSquares().numSquares(13));
    assertEquals(4, new PerfectSquares().numSquares(9151));
    assertEquals(2, new PerfectSquares().numSquares(19898));
  }

}
