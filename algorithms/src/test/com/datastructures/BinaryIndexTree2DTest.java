package com.datastructures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.datastructures.BinaryIndexTree2D;

public class BinaryIndexTree2DTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBinaryIndexTree2D() throws Exception {
		int arr[][] = {{ 1,1,1,1},{2,2,2,2},{3,3,3,3},{4,4,4,4}};
		BinaryIndexTree2D b2d = new BinaryIndexTree2D(arr);
		assertEquals(40, b2d.getSum(3, 3));
		assertEquals(24, b2d.getSum(2, 3));
		assertEquals(12, b2d.getSum(1, 3));
		assertEquals(4, b2d.getSum(0, 3));
		assertEquals(14, b2d.getSum(2, 2, 3, 3));
	}

}
