package com.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a set of words (without duplicates), find all word squares you can build from them.

A sequence of words forms a valid word square if the kth row and column read the exact same string, 
where 0 ≤ k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because 
each word reads the same both horizontally and vertically.

b a l l
a r e a
l e a d
l a d y
Note:
There are at least 1 and at most 1000 words.
All words will have the exact same length.
Word length is at least 1 and at most 5.
Each word contains only lowercase English alphabet a-z.
Example 1:

Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
Example 2:

Input:
["abat","baba","atan","atal"]

Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
 * @author nraveend
 *
 */
public class WordSquares {
	/**
	 * Recursive backtracking
	 * Build a lookup of character to list of strings
	 * For each word try to build a square. If solution found ,  add words to result
	 * Each step , add a word only if it is a match.
	 * @param words
	 * @return
	 */
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        List<String> curList = new ArrayList<>();
        
        Map<Character, List<String>> wl = new HashMap<>();
        
        for(int i = 0; i < words.length ; ++i) {
        	if(wl.containsKey(words[i].charAt(0))) {
        		wl.get(words[i].charAt(0)).add(words[i]);
        	}
        	else {
        		List<String> list = new ArrayList<>();
        		list.add(words[i]);
        		wl.put(words[i].charAt(0), list);
        	}
        }
        
        if(words.length > 0) {
        	int squareSize = words[0].length();
        	for(int i = 0; i < words.length ; ++i) {
        		curList.add(words[i]);
        		buildSqaure(curList, wl, squareSize, result);
        		curList.remove(words[i]);
        	}
        }
        return result;
    }

	private void buildSqaure(List<String> curList, Map<Character, List<String>> wl, int squareSize,
			List<List<String>> result) {
		if(squareSize == curList.size()) {
			result.add(new ArrayList<>(curList));
			return;
		}
		
		int curRow = curList.size();
		String firstRowStr = curList.get(0);
		Character curRowStart = firstRowStr.charAt(curRow);
		if(wl.containsKey(curRowStart)) {
			List<String> rowCandidates = wl.get(curRowStart);
			for(String str : rowCandidates) {
				if(!curList.contains(str) && isMatch(str, curList)) {
					curList.add(str);
					buildSqaure(curList, wl, squareSize, result);
					curList.remove(curList.size() -1);
				}
			}
		}
	}

	private boolean isMatch(String str, List<String> curList) {
		int curRow = curList.size();
		boolean match = true;
		for(int i = 0 ; i < curList.size() ; ++i) {
			if(str.charAt(i) != curList.get(i).charAt(curRow)) {
				match = false;
				break;
			}
		}
		return match;
	}
}
