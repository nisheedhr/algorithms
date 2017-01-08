package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) 
 * from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
 * @author nisheedh
 *
 */
public class WordBreakTwo {

    /**
     * use BFS. For every word, maintain the list of parents. and level number.
     * A parent is added to current parent list of a word, only if the new parent's level matches existing parents of the word.
     * Core functions
     * getOneEditWords - Get one edit words which are dictionary from current word
     * buildPaths - Build all possible paths once end word matches . Use recursion here. Add  new list for every parent list which mas more than one entry.
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> out = new ArrayList<List<String>>();
        fl(beginWord, endWord, wordList, out);
        return out;
    }

    private void fl(String beginWord, String endWord, Set<String> wordList, List<List<String>> out) {
        if (beginWord == null || beginWord.isEmpty()) {
            return ;
        }
        
        Map<String, List<String>> visitedParents = new HashMap<>();
        
        Queue<String> bfsQ = new LinkedList<>();
        Map<String, Integer> lm = new HashMap<>();
        bfsQ.offer(beginWord);
        List<String> parents = new ArrayList<>();
        visitedParents.put(beginWord, parents);
        lm.put(beginWord, 1);
        while (!bfsQ.isEmpty()) {
            String current = bfsQ.poll();
            if (current.equals(endWord)) {
                List<String> curList = new ArrayList<>();
                out.add(curList);
                buildPaths(out, beginWord, current, curList, visitedParents);
                return;
            }
            
            for(String word : getOneEditWord(current, wordList)) {
                if(!visitedParents.containsKey(word)){
                    List<String> curParents = new ArrayList<>();
                    curParents.add(current);
                    visitedParents.put(word, curParents);
                    lm.put(word, lm.get(current) + 1);
                    bfsQ.offer(word);
                } else if (visitedParents.containsKey(word) && lm.get(word) == lm.get(current) + 1) {
                    visitedParents.get(word).add(current);
                }
            }
        }
        
    }

    private void buildPaths(List<List<String>> out, String beginWord, String current, List<String> curList, Map<String, List<String>> visitedParents) {
        curList.add(0,current);
        if (current.equals(beginWord)) {
            return;
        }
        
        List<String> parents = visitedParents.get(current);
        
        List<List<String>> tmpList = new ArrayList<>();
        for (int i = 0 ; i < parents.size(); ++i) {
            if (i ==0) {
                tmpList.add(curList);
            } else {
                ArrayList<String> newList = new ArrayList<>(curList);
                out.add(newList);
                tmpList.add(newList);
            }
        }
        
        for (int i = 0 ; i < parents.size(); ++i) {
            buildPaths(out, beginWord, parents.get(i), tmpList.get(i), visitedParents);
        }
    }

    private List<String> getOneEditWord(String current, Set<String> wordList) {
        char [] arr = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        List<String> out = new ArrayList<>();
        StringBuilder sb = new StringBuilder(current);
        for (int i = 0; i < current.length(); ++i) {
            char ch = sb.charAt(i);
            for (int j = 0; j < arr.length; ++j) {
                if (ch != arr[j]) {
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
