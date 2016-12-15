package com.datastructures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.datastructures.RRDCircularBuffer;

public class RRDCircularBufferTest {

	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testRRDCircularBuffer() throws Exception {
		RRDCircularBuffer rrd = new RRDCircularBuffer(5);
		rrd.addValue(5);
		rrd.addValue(3);
		rrd.addValue(4);
		rrd.addValue(1);
		rrd.addValue(2);
		assertEquals(1, rrd.getMin());
		assertEquals(5, rrd.getMax());
		assertEquals(3.0, rrd.getAverage(), 0);
		rrd.addValue(5);
		rrd.addValue(5);
		rrd.addValue(5);
		rrd.addValue(5);
		rrd.addValue(5);
		assertEquals(5.0, rrd.getAverage(), 0);
	}

}
