package com.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 * @author nisheedh
 *
 */
public class AnagramsInString {

    /**
     * Maintain a char map of count of chars in anagram string
     * Traverse large string and build a tmp char map. Compare tmp char map
     * to anagram char map if length matches. If comparison succeeds add pos to output.
     * If character doesn't exist in anagram char map, set curlength to 0 to skip all previous chars.
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> out = new ArrayList<>();
        int charMap[] = new int[26];
        int tmpMap[] = new int[26];
        
        for (int i = 0; i < p.length() ; ++i) {
            int pos = p.charAt(i) -'a';
            charMap[pos] = charMap[pos] + 1;
        }
        
        int curLength = 0;
        for (int i = 0; i < s.length() ; ++i) {
            int pos = s.charAt(i) - 'a';
            // char doesn't exist in anagram
            if (charMap[pos] == 0) {
                curLength = 0;
                tmpMap = new int[26];
            } else {
                tmpMap[pos] = tmpMap[pos] + 1;
                curLength++;
                if (curLength == p.length()) {
                    if (Arrays.equals(charMap, tmpMap)) {
                        out.add(i - p.length() + 1);
                    }
                    curLength--;
                    int oldPos = s.charAt(i - p.length() + 1) - 'a';
                    tmpMap[oldPos] = tmpMap[oldPos] - 1;
                }
            }
        }
        return out;
    }
}
