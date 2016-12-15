package com.graph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.graph.BombEnemy;

public class BombEnemyTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMaxKilledEnemies() throws Exception {
		char grid[][] = {{'0', 'E', '0', '0'},
				{'E', '0', 'W', 'E'},
				{'0', 'E', '0', '0'}};
		BombEnemy bomEnem = new BombEnemy();
		assertEquals(3, bomEnem.maxKilledEnemies(grid));
	}


}
