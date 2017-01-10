package com.strings;

/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?
 * @author nisheedh
 *
 */
public class ReverseWordsInString {

    /**
     * Reverse the whole sentence. Then reverse
     * Individual words
     * @param s
     */
    public void reverseWords(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        
        reverseWords(s, 0, s.length -1);
        
        int wb = 0;
        int we = 0;
        for (int i = 0; i < s.length ; ++i) {
            if (s[i] == ' ') {
                reverseWords(s, wb, we);
                wb = i +1;
                we = i;
            } else {
                we = i;
            }
        }
        reverseWords(s, wb, we);
    }

    private void reverseWords(char[] s, int beg, int end) {
       if (end > beg) {
           int mid = beg + (end -beg)/ 2;
           for (int i = beg, j = 0; i <= mid; ++i, ++j) {
               char ch = s[i];
               s[i] = s[end -j];
               s[end -j] = ch;
           }
       }
        
    }
}
