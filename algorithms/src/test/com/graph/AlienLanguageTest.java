package com.graph;

import static org.junit.Assert.*;

import org.junit.Test;

import com.graph.AlienLanguage;

public class AlienLanguageTest {

	@Test
	public void testAlienOrder() throws Exception {
		String[] words = { "wrt", "wrf", "er", "ett", "rftt" };
		AlienLanguage al = new AlienLanguage();
		assertEquals("wertf", al.alienOrder(words));
	}

}
