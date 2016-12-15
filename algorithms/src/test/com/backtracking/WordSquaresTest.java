package com.backtracking;

import org.junit.Before;
import org.junit.Test;

import com.backtracking.WordSquares;

public class WordSquaresTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testWordSquares() throws Exception {
		String input[] = {"area","lead","wall","lady","ball"};
		WordSquares ws = new WordSquares();
		System.out.println(ws.wordSquares(input));
	}

}
