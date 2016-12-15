package com.graph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.graph.ShortestDistanceAllBuildings;

public class ShortestDistanceAllBuildingsTest {

	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testComputeShortestDistance() throws Exception {
		int[][] grid = {{1,0,2,0,1}, {0,0,0,0,0},{0,0,1,0,0}};
		ShortestDistanceAllBuildings sb = new ShortestDistanceAllBuildings();
		assertEquals(7, sb.shortestDistance(grid));
		assertEquals(7, sb.shortestDistance2(grid));
		int[][] grid2 = {{1}, {0},{1}};
		assertEquals(2, sb.shortestDistance(grid2));
		assertEquals(2, sb.shortestDistance2(grid2));
		Math.addExact(10, 20);
	}

}
