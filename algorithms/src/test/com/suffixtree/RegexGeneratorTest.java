package com.suffixtree;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.suffixtree.RegexGenerator;

public class RegexGeneratorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBuildRegex() throws Exception {
		List<String> input = new ArrayList<>();
		input.add("abc");
		input.add("abd");
		input.add("abe");
		RegexGenerator regGen = new RegexGenerator();
		assertEquals("ab(c|d|e)", regGen.buildRegex(input));
		
		input.clear();
		input.add("abce");
		input.add("abd");
		input.add("abe");
		input.add("abcf");
		assertEquals("ab(c(e|f)|d|e)", regGen.buildRegex(input));
		
	}


}
