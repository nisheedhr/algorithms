package com.array;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.array.MissingRanges;

public class MissingRangesTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindMissingRanges() throws Exception {
		MissingRanges mr = new MissingRanges();
		int arr[] = {0,  1,  3, 50, 75};
		List<String> result = mr.findMissingRanges(arr, 0, 99);
		System.out.println(result);
	}

}
