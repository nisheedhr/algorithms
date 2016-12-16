package com.topdown;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.topdown.LongestTwoSubStr;

public class LongestTwoSubStrTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testLengthOfLongestSubstringTwoDistinct() throws Exception {
    assertEquals(3, new LongestTwoSubStr().lengthOfLongestSubstringTwoDistinct("eceba"));
    assertEquals(0, new LongestTwoSubStr().lengthOfLongestSubstringTwoDistinct(""));
    assertEquals(1, new LongestTwoSubStr().lengthOfLongestSubstringTwoDistinct("a"));
    assertEquals(2, new LongestTwoSubStr().lengthOfLongestSubstringTwoDistinct("ab"));
    assertEquals(7, new LongestTwoSubStr().lengthOfLongestSubstringTwoDistinct("abababa"));
    assertEquals(8, new LongestTwoSubStr().lengthOfLongestSubstringTwoDistinct("aaabbbbdddd"));
    assertEquals(9, new LongestTwoSubStr().lengthOfLongestSubstringTwoDistinct("cabcccacacccbbcbb"));
  }
  
  @Test
  public void testLengthOfLongestSubstringTwoDistinctNew() throws Exception {
    assertEquals(3, new LongestTwoSubStr().lengthOfLongestSubstringTwoDistinctNew("eceba"));
    assertEquals(0, new LongestTwoSubStr().lengthOfLongestSubstringTwoDistinctNew(""));
    assertEquals(1, new LongestTwoSubStr().lengthOfLongestSubstringTwoDistinctNew("a"));
    assertEquals(2, new LongestTwoSubStr().lengthOfLongestSubstringTwoDistinctNew("ab"));
    assertEquals(7, new LongestTwoSubStr().lengthOfLongestSubstringTwoDistinctNew("abababa"));
    assertEquals(8, new LongestTwoSubStr().lengthOfLongestSubstringTwoDistinctNew("aaabbbbdddd"));
    assertEquals(9, new LongestTwoSubStr().lengthOfLongestSubstringTwoDistinctNew("cabcccacacccbbcbb"));
  }

}
