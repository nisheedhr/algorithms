package com.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke"
 is a subsequence and not a substring.
 * @author nisheedh
 *
 */
public class LongestSubStringWithoutRepeating {

    /**
     * Just use a 26 char arry or Map for previous positions of encountered character
     * If current char position is greater than beginning of current sub string begin
     * adjust current beginning
     * else 
     * increase the sub string length
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> posMap = new HashMap<>();
        int maxLen = 0;
        int curLen = 0;
        int curBeg = -1;
        
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (curBeg == -1) {
                posMap.put(ch, i);
                curBeg = 0;
                curLen++;
            }else if (posMap.containsKey(ch) && posMap.get(ch) >= curBeg) { // repeated character
                int oldPos = posMap.get(ch);
                posMap.put(ch, i);
                curLen = i - oldPos;
                curBeg = oldPos + 1;
            } else {
                posMap.put(ch, i);
                curLen++;
            }
            
            if (curLen > maxLen) {
                maxLen = curLen;
            }
        }
        return maxLen;
    }
}
