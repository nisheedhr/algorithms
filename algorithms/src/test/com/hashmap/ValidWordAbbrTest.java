package com.hashmap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.hashmap.ValidWordAbbr;

public class ValidWordAbbrTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsUnique() throws Exception {
		String dictionary[] = { "deer", "door", "cake", "card" , "ayh", "aih"} ;
		ValidWordAbbr tObj = new ValidWordAbbr(dictionary);
		assertEquals(true, tObj.isUnique("cart"));
		assertEquals(false, tObj.isUnique("dear"));
		assertEquals(false, tObj.isUnique("cane"));
		assertEquals(true, tObj.isUnique("make"));
		assertEquals(false, tObj.isUnique("ayh"));
	}

}
