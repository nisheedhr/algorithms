package com.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 * @author nisheedh
 *
 */
public class SortCharsByFrequency {

    private static class CharNode {
        char ch;
        int num;
        CharNode (int num, char ch) {
            this.num = num;
            this.ch = ch;
        }
    }
    /**
     * Use a priority queue to sort
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0 ; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if(charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }
        
        PriorityQueue<CharNode> pq = new PriorityQueue<>((a, b) -> b.num - a.num);
        
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            pq.offer(new CharNode(entry.getValue(), entry.getKey()));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!pq.isEmpty()) {
            CharNode top = pq.poll();
            for (int i = 0; i < top.num; ++i) {
                sb.append(top.ch);
            }
        }
        return sb.toString();
    }
}
