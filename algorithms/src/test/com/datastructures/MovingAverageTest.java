package com.datastructures;

import org.junit.Before;
import org.junit.Test;

import com.datastructures.MovingAverage;

public class MovingAverageTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testNext() throws Exception {
		MovingAverage mv = new MovingAverage(3);
		mv.next(1);
		mv.next(10);
		mv.next(3);
	}

}
