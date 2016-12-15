package com.datastructures;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.datastructures.LRUCache;



public class LRUCacheTest {
	private LRUCache lRUCache;

	@Before
	public void createLRUCache() throws Exception {
		lRUCache = new LRUCache(2);
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLRUCache() throws Exception {
		lRUCache.set(2, 1);
		lRUCache.set(1, 1);
		lRUCache.get(2);
		lRUCache.set(4, 2);
		assertEquals(-1, lRUCache.get(1));
		assertEquals(1, lRUCache.get(2));
	}

}
