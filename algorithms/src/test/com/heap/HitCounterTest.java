package com.heap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.heap.HitCounter;

public class HitCounterTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testGetHits() throws Exception {
    HitCounter hc = new HitCounter();
    hc.hit(1);
    hc.hit(2);
    hc.hit(3);
    assertEquals(3, hc.getHits(4));
    hc.hit(300);
    assertEquals(4, hc.getHits(300));
    assertEquals(3, hc.getHits(301));
  }

  @Test
  public void testGetHitsNew() throws Exception {
    HitCounter hc = new HitCounter();
    hc.hitNew(1);
    hc.hitNew(2);
    hc.hitNew(3);
    assertEquals(3, hc.getHitsNew(4));
    hc.hitNew(300);
    assertEquals(4, hc.getHitsNew(300));
    assertEquals(3, hc.getHitsNew(301));
  }
}
