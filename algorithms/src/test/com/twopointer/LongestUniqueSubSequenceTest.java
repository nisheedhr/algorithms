package com.twopointer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.twopointer.LongestUniqueSubSequence;

public class LongestUniqueSubSequenceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLengthOfLongestSubstringKDistinct() throws Exception {
		LongestUniqueSubSequence lobj = new LongestUniqueSubSequence();
		assertEquals(3, lobj.lengthOfLongestSubstringKDistinct("eceba", 2));
		assertEquals(4, lobj.lengthOfLongestSubstringKDistinct("ecebaba", 2));
	}

}
