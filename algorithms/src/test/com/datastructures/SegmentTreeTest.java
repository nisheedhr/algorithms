package com.datastructures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.datastructures.SegmentTree;

public class SegmentTreeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetSumIntInt() throws Exception {
		int arr[] = { 1, 3, 5, 7, 9 };
		SegmentTree segTree = new SegmentTree(arr);
		assertEquals(25, segTree.getSum(0, 4));
		assertEquals(9, segTree.getSum(0, 2));
		assertEquals(4, segTree.getSum(0, 1));
		assertEquals(16, segTree.getSum(3, 4));
		assertEquals(16, segTree.getSum(0, 3));
		assertEquals(15, segTree.getSum(1, 3));
	}

	@Test
	public void testUpdateIntInt() throws Exception {
		int arr[] = { 1, 3, 5, 7, 9 };
		SegmentTree segTree = new SegmentTree(arr);
		assertEquals(25, segTree.getSum(0, 4));
		segTree.update(0, 6);
		assertEquals(30, segTree.getSum(0, 4));
		assertEquals(14, segTree.getSum(0, 2));
	}

}
