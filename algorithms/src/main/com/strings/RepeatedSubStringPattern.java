package com.strings;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and 
 * appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 * @author nisheedh
 *
 */
public class RepeatedSubStringPattern {

    /**
     * odd length - all chars should be same
     * even length - check if half are same
     * if multiple of 3 and even check if string can be built using 3 parts
     * @param str
     * @return
     */
    public boolean repeatedSubstringPattern(String str) {
        if (str == null || str.isEmpty() || str.length() == 1) {
            return false;
        } else if (str.length() % 2 != 0) {
            if (str.length() % 3 == 0 && isThreePartString(str)) {
                return true;
            }
            char ch = str.charAt(0);
            for (int i = 1; i < str.length() ; ++i) {
                if (ch != str.charAt(i)) {
                    return false;
                }
            }
            return true;
        } else {
            String half = str.substring(0, str.length() / 2);
            StringBuilder sb = new StringBuilder(half);
            sb.append(half);
            if (str.equals(sb.toString())) {
                return true;
            } else if (str.length() % 3 == 0) {
                return isThreePartString(str);
            } else {
                return false;
            }
        }
    }

    private boolean isThreePartString(String str) {
        String third = str.substring(0, str.length() / 3);
        int j = 0;
        for (int i = str.length() / 3; i < str.length() ; ++i) {
            if (str.charAt(i) != third.charAt(j)) {
                return false;
            }
            j++;
            if (j == str.length() /3) {
                j = 0;
            }
        }
        return true;
    }
}
