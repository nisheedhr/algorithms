package com.backtracking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.backtracking.AndroidLockPatterns;

public class AndroidLockPatternsTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testNumberOfPatterns() throws Exception {
    assertEquals(9, new AndroidLockPatterns().numberOfPatterns(1, 1));
    assertEquals(56, new AndroidLockPatterns().numberOfPatterns(2, 2));
    assertEquals(65, new AndroidLockPatterns().numberOfPatterns(1, 2));
    assertEquals(320, new AndroidLockPatterns().numberOfPatterns(3, 3));
  }

}
