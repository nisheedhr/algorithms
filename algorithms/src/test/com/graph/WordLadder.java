package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest 
 * transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 * @author nisheedh
 *
 */
public class WordLadder {

    /**
     * Graph problem. Use BFS
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Map<String, Integer> visitMap = new HashMap<>();
        Queue<String> bfsQ = new LinkedList<>();
        bfsQ.offer(beginWord);
        visitMap.put(beginWord, 1);

        while (!bfsQ.isEmpty()) {
            String curWord = bfsQ.poll();
            if (curWord.equals(endWord)) {
                return visitMap.get(curWord);
            } else {
                int curLen = visitMap.get(curWord);
                for (String word : getOneEditWord(curWord, wordList)) {
                    if (!visitMap.containsKey(word)) {
                        visitMap.put(word, curLen + 1);
                        bfsQ.offer(word);
                    }
                }
            }
        }
        return 0;
    }

    private List<String> getOneEditWord(String curWord, Set<String> wordList) {
        List<String> out = new ArrayList<>();

        char arr[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (int i = 0; i < curWord.length(); ++i) {
            StringBuilder sb = new StringBuilder(curWord);
            char ch = curWord.charAt(i);
            for (int j = 0; j < arr.length; ++j) {
                if (arr[j] != ch) {
                    sb.setCharAt(i, arr[j]);
                    if (wordList.contains(sb.toString())) {
                        out.add(sb.toString());
                    }
                    sb.setCharAt(i, ch);
                }
            }
        }
        return out;
    }
}
