package com.strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseWordsInStringTest {

    @Test
    public void testReverseWordsCharArray() throws Exception {
       new ReverseWordsInString().reverseWords(new char[]{'a', ' ', 'b'});
    }

}
