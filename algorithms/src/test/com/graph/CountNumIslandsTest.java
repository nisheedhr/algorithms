package com.graph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.graph.CountNumIslands;

public class CountNumIslandsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testNumIslands() throws Exception {
		char[][] input = { {'1','1','1','1','0'}, {'1','1','0','1','0'},
				{'1','1','0','0','0'}, {'0','0','0','0','0'} };
		
		CountNumIslands cnt = new CountNumIslands();
		assertEquals(1,cnt.numIslands(input));
		
		char[][] input2 = { {'1','1','0','0','0'}, {'1','1','0','0','0'},
				{'0','0','1','0','0'}, {'0','0','0','1','0'} };
		assertEquals(3,cnt.numIslands(input2));
	}
}

