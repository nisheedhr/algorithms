package com.datastructures;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LFUCacheTest {

    @Test
    public void testLFUCache() throws Exception {
        LFUCache cache = new LFUCache(2);
        cache.set(1, 1); 
        cache.set(2, 2); 
        assertEquals(1,cache.get(1));
        cache.set(3, 3);
        assertEquals(-1,cache.get(2));
        assertEquals(3,cache.get(3));
        cache.set(4, 4);
        assertEquals(-1,cache.get(1));
        assertEquals(3,cache.get(3));
        assertEquals(4,cache.get(4));
    }

}
