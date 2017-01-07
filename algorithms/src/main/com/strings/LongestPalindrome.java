package com.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
 * @author nisheedh
 *
 */
public class LongestPalindrome {

    /**
     * Find using longest subsequence of reverse string.
     * Check if positions match for longest subsequence. There can be longest
     * subsequence at different positions. It cannot be a palindrome. Iterate
     * over original string in inner loop. In outer loop, pick a character from reverse of
     * the string
     * Use -1 for null character
     *   # A B A B
     * # 0 0 0 0 0
     * B 0 0 1 0 1
     * A 0 1 0 2 0
     * B 0 0 2 0 3
     * A 0 1 0 3 0
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int low = 0;
        int high = 0;
        int prev[] = new int[s.length() +1];
        int cur[] = new int[s.length() + 1];
        
        for (int j = s.length(); j >= 0 ; --j) {
            for (int k = 0,  i = -1 ; i < s.length(); ++i, ++k) {
                if (i == -1 || j == s.length()) {
                    cur[k] = 0;
                } else {
                    char ch = s.charAt(i);
                    char pch = s.charAt(j);
                    if (ch == pch) {
                        cur[k] = prev[k -1] + 1;
                        if (cur[k] > maxLen && s.charAt(i) == s.charAt(i - cur[k] + 1)) {
                            maxLen = cur[k];
                            low = i - cur[k] + 1;
                            high = i;
                        }
                    } else {
                        cur[k] = 0;
                    }
                }
            }
            
            int tmp[] = prev;
            prev = cur;
            cur = tmp;
        }
        return s.substring(low, high + 1);
    }
    
    public String longestPalindromeOld(String s) {
        int maxLen = 0;
        String maxStr = null;
        Map<Character, List<Integer>> posMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (posMap.containsKey(ch)) {
                posMap.get(ch).add(i);
            } else {
                List<Integer> posList = new ArrayList<>();
                posList.add(i);
                posMap.put(ch, posList);
            }
        }
        
        for (Map.Entry<Character, List<Integer>> entry : posMap.entrySet()) {
            List<Integer> posList = entry.getValue();
            if (posList.size() == 1) {
                if (maxLen == 0) {
                    maxLen = 1;
                    maxStr = Character.toString(entry.getKey());
                }
                continue;
            } else {
                for (int i = 0; i < posList.size() - 1; ++i) {
                    int j = posList.size() - 1;
                    int curLen = posList.get(j) - posList.get(i) + 1;
                    // No need to check further
                    if (curLen < maxLen) {
                        break;
                    }
                    for (; j > 0; --j) {
                        curLen = posList.get(j) - posList.get(i) + 1;
                        // No need to check further
                        if (curLen < maxLen) {
                            break;
                        }
                        String sub = s.substring(posList.get(i), posList.get(j) + 1);
                        if (isPalindrome(sub)) {
                            maxStr = sub;
                            maxLen = sub.length();
                            break; // No need to check further
                        }
                    }
                }
            }
        }
        return maxStr;
    }

    private boolean isPalindrome(String sub) {
        boolean pal = true;
        for (int i = 0; i < sub.length() / 2; ++i) {
            if (sub.charAt(i) != sub.charAt(sub.length() - i - 1)) {
                pal = false;
                break;
            }
        }
        return pal;
    }
}
