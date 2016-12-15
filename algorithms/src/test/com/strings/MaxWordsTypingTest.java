package com.strings;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.strings.MaxWordsTyping;

public class MaxWordsTypingTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testWordsTyping() throws Exception {
		MaxWordsTyping mw = new MaxWordsTyping();
		String sentence[] = {"hello", "world"};
		assertEquals(1, mw.wordsTyping(sentence, 2, 8));
		String sentence1[] = {"a", "bcd", "e"};
		assertEquals(2, mw.wordsTyping(sentence1, 3, 6));
		String sentence2[] = {"I", "had", "apple", "pie"};
		assertEquals(1, mw.wordsTyping(sentence2, 4, 5));
		String sentence3[] = {"f", "p", "a"};
		assertEquals(10, mw.wordsTyping(sentence3, 8, 7));
		String sentence4[] = {"a", "b", "e"};
		assertEquals(666666, mw.wordsTyping(sentence4, 2000, 2000));
	}

}
