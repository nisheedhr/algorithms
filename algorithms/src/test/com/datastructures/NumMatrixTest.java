package com.datastructures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.datastructures.NumMatrix;

public class NumMatrixTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetSum() throws Exception {
		int matrix[][] = {
		          {3, 0, 1, 4, 2},
		          {5, 6, 3, 2, 1},
		          {1, 2, 0, 1, 5},
		          {4, 1, 0, 1, 7},
		          {1, 0, 3, 0, 5}
		          };
		NumMatrix matTest = new NumMatrix(matrix);
		assertEquals(8, matTest.sumRegion(2, 1, 4, 3));
		matTest.update(3, 2, 2);
		assertEquals(10, matTest.sumRegion(2, 1, 4, 3));
	}

}
