package com.bit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bit.UTF8Validation;

public class UTF8ValidationTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testValidUtf8() throws Exception {
		UTF8Validation utf = new UTF8Validation();
		int arr[] = { 197, 130, 1};
		assertEquals(true, utf.validUtf8(arr));
		int arr2[] = { 235, 140, 4};
		assertEquals(false, utf.validUtf8(arr2));
	}

}
