package com.strings;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.strings.DecodeString;

public class DecodeStringTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testDecodeString() throws Exception {
    DecodeString dc = new DecodeString();
    assertEquals("ababc", dc.decodeString("2[ab]1[c]"));
    assertEquals("accaccacc", dc.decodeString("3[a2[c]]"));
    assertEquals("abcabccdcdcdef", dc.decodeString("2[abc]3[cd]ef"));
    assertEquals("abcabccdcdcdef", dc.decodeString("abcabccdcdcdef"));
  }

}
