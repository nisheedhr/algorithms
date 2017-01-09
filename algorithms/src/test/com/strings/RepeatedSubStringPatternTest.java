package com.strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class RepeatedSubStringPatternTest {

    @Test
    public void testRepeatedSubstringPattern() throws Exception {
       String input = "bacbacbac";
       assertEquals(true, new RepeatedSubStringPattern().repeatedSubstringPattern(input));
    }

}
