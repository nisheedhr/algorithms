package com.datastructures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.datastructures.BinaryIndexTree;

public class BinaryIndexTreeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBinaryIndexTree() throws Exception {
		int freq[] = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
		BinaryIndexTree bit = new BinaryIndexTree(freq);
		assertEquals(12, bit.getSum(5));
		bit.update(3, 6);
		assertEquals(18, bit.getSum(5));
	}

}
