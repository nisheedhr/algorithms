package com.strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramsInStringTest {

    @Test
    public void testFindAnagrams() throws Exception {
        AnagramsInString as = new AnagramsInString();
        assertEquals(2, as.findAnagrams("cbaebabacd", "abc").size());
        assertEquals(3, as.findAnagrams("abab", "ab").size());
    }

}
