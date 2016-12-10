package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * There is a new alien language which uses the latin alphabet. However, the
 * order among letters are unknown to you. You receive a list of words from the
 * dictionary, where words are sorted lexicographically by the rules of this new
 * language. Derive the order of letters in this language.
 * 
 * For example, Given the following words in dictionary,
 * 
 * [ "wrt", "wrf", "er", "ett", "rftt" ] The correct order is: "wertf". You may
 * assume all letters are in lowercase. If the order is invalid, return an empty
 * string. There may be multiple valid order of letters, return any one of them
 * is fine.
 * 
 * @author nisheedh
 *
 */
public class AlienLanguage {

	private enum VisitState {
		UNVISITED,
		VISITING,
		VISITED
	};
	/**
	 * Key idea is to generate a graph for the words by creating an edge between
	 * previous char and current one if it exists.
	 * An edge exists between first char of previous word and first char of current word.
	 * An edge also exists if substrings between 2 strings match.
	 * Do a topological sort and return the result.
	 * If loop exists no result possible. 
	 * 
	 * @param words
	 * @return
	 */
	public String alienOrder(String[] words) {
		if (words == null || words.length == 0) {
			return "";
		}
		String prevString = null;
		Character prevChar = null;
		Map<Character, List<Character>> edgeMap = new HashMap<>();
		for (String word: words) {
			// Invalid order smaller sub string should come before larger one.
			if (prevString != null && prevString.length() > word.length() && 
					prevString.substring(0, word.length()).equals(word)) {
				return "";
			}
			
			for (int i = 0; i < word.length() ; ++i) {
				char ch = word.charAt(i);
				if (!edgeMap.containsKey(ch)) {
					edgeMap.put(ch, new ArrayList<>());
				}
				
				if (prevChar != null) {
					if (!prevChar.equals(ch)) {
						List<Character> adjList = edgeMap.get(prevChar);
						if (!adjList.contains(ch)) {
							adjList.add(ch);
						}
					}
					
					if(isSubString(prevString, word, i)) {
						prevChar = prevString.charAt(i + 1);
					} else {
						prevChar = null;
					}
				}
			}
			prevString = word;
			prevChar = word.charAt(0);
		}
		
		Map<Character, VisitState> visited = new HashMap<>();
		for (Character ch : edgeMap.keySet()) {
			visited.put(ch, VisitState.UNVISITED);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (Character ch : edgeMap.keySet()) {
			if (!dfs(ch, edgeMap, visited, sb)) {
				return "";
			}
		}
		return sb.toString();
	}
	
	private boolean dfs(Character ch, Map<Character, List<Character>> edgeMap, Map<Character, VisitState> visited,
			StringBuilder sb) {
		// Detected a loop
		if (visited.get(ch) == VisitState.VISITING) {
			return false;
		} else if (visited.get(ch) == VisitState.UNVISITED) {
			visited.put(ch, VisitState.VISITING);
			for (Character w : edgeMap.get(ch)) {
				if (!dfs(w, edgeMap, visited, sb)) {
					return false;
				}
			}
			sb.insert(0, ch);
			visited.put(ch, VisitState.VISITED);
		}
		return true;
	}

	private boolean isSubString(String prevString, String word, int pos) {
		return prevString.length() > pos +1 && word.length() > pos + 1 && prevString.substring(0,  pos + 1).equals(word.substring(0, pos + 1));
	}

}
