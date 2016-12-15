package com.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.stack.LongestAbsoluteFilePath;

public class LongestAbsoluteFilePathTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLengthLongestPath1() throws Exception {
		LongestAbsoluteFilePath lfp = new LongestAbsoluteFilePath();
		assertEquals(32, lfp.lengthLongestPath1(
				"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
		assertEquals(12, lfp.lengthLongestPath1("dir\n\tfile.txt"));
	}

	@Test
	public void testLengthLongestPath() throws Exception {
		LongestAbsoluteFilePath lfp = new LongestAbsoluteFilePath();
		assertEquals(32, lfp.lengthLongestPath(
				"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
		assertEquals(12, lfp.lengthLongestPath("dir\n\tfile.txt"));
	}

}
