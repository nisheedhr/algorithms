package com.backtracking;

import java.util.List;

import org.junit.Test;

public class GenerateAbbrvnTest {

	@Test
	public void testGenerateAbbreviations() throws Exception {
		List <String> res = new GenerateAbbrvn().generateAbbreviations("word");
		
		StringBuilder sb = new StringBuilder();
		for (String inp: res) {
			sb.append(inp);
			sb.append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
