package com.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine 
 * if s can be segmented into a space-separated sequence of one or more dictionary words. 
 * You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

UPDATE (2017/1/4):
The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please 
reload the code definition to get the latest changes.
 * @author nisheedh
 *
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> cache = new HashMap<>();
        return wordBreakImpl(s, new HashSet<String>(wordDict), cache);
    }
    /**
     * Build a lookup of char to  set of strings
     * set of strings should be in descending order so that comparison can be done against largest string
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreakOld(String s, List<String> wordDict) {
        Map<Character, Set<String>> lk = new HashMap<>();
        for (String word : wordDict) {
            char ch = word.charAt(0);
            if (lk.containsKey(ch)) {
                lk.get(ch).add(word);
            } else {
                Set<String> set = new TreeSet<String>((a, b) -> b.compareTo(a));
                set.add(word);
                lk.put(ch, set);
            }
        }
        Map<String, Boolean> cache = new HashMap<>();
        return wordBreakImpl(s, lk, cache);
    }

    private boolean wordBreakImpl(String s, Map<Character, Set<String>> lk, Map<String, Boolean> cache ) {
        if (s == null || s.isEmpty()) {
            return false;
        } else if (cache.containsKey(s)) {
            return cache.get(s);
        }
        
        char ch = s.charAt(0);
        
        if (lk.containsKey(ch)) {
            for (String word : lk.get(ch)) {
                if(s.equals(word)){
                    return true;
                } else if (s.indexOf(word) == 0) {
                    if (wordBreakImpl(s.substring(word.length()), lk, cache)) {
                        cache.put(s, true);
                        return true;
                    }
                }
            }
        }
        cache.put(s, false);
        return false;
    }

    private boolean wordBreakImpl(String s, Set<String> hashSet, Map<String, Boolean> cache) {
        if (s == null || s.isEmpty()) {
            return false;
        } else if (cache.containsKey(s)) {
            return cache.get(s);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            sb.append(s.charAt(i));
            if (hashSet.contains(sb.toString())) {
                if (i == s.length() - 1 || wordBreakImpl(s.substring(i + 1), hashSet, cache)) {
                    cache.put(s, true);
                    return true;
                }
            }
        }
        cache.put(s, false);
        return false;
    }
}
