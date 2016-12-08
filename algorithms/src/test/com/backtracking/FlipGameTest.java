package com.backtracking;

import static org.junit.Assert.*;

import org.junit.Test;

public class FlipGameTest {

	@Test
	public void testCanWinString() throws Exception {
		String input = "+++++";
		assertEquals(false, new FlipGame().canWin(input));
	}

}
