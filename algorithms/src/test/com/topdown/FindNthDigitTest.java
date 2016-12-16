package com.topdown;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.topdown.FindNthDigit;

public class FindNthDigitTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testFindNthDigit() throws Exception {
    assertEquals(2, new FindNthDigit().findNthDigit(2147483647));
    assertEquals(3, new FindNthDigit().findNthDigit(1000));
    assertEquals(1, new FindNthDigit().findNthDigit(1000000000));
    assertEquals(0, new FindNthDigit().findNthDigit(11));
    assertEquals(3, new FindNthDigit().findNthDigit(3));
    assertEquals(1, new FindNthDigit().findNthDigit(10));
  }

}
