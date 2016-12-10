package com.datastructures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.datastructures.SegmentTreeRangeMin;

public class SegmentTreeRangeMinTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetMinIntInt() throws Exception {
		int arr[] = { 2, 5, 1, 4, 9 , 3};
		SegmentTreeRangeMin segTree = new SegmentTreeRangeMin(arr);
		assertEquals(1, segTree.getMin(0, 5));
		assertEquals(1, segTree.getMin(0, 2));
		assertEquals(2, segTree.getMin(0, 1));
		assertEquals(2, segTree.getMin(0, 0));
		assertEquals(1, segTree.getMin(0, 3));
		assertEquals(1, segTree.getMin(0, 4));
		assertEquals(1, segTree.getMin(2, 4));
		assertEquals(4, segTree.getMin(3, 4));
		assertEquals(3, segTree.getMin(3, 5));
	}

}
