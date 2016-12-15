package com.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = �eceba� and k = 2,

T is "ece" which its length is 3.
 * @author nraveend
 *
 */
public class LongestUniqueSubSequence {

	/**
	 * Greedy algorithm.
	 * Store current beginning and iterate and compute max substring.
	 * Once number of chars exceed k. pop out characters from current beginning till length falls below k.
	 * @param s
	 * @param k
	 * @return
	 */
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		Map<Character, Integer> seenCharMap = new HashMap<>();
		int maxLen = 0;
		int curBeg = 0;
		
		for (int i = 0; i < s.length() ; ++i) {
			char ch = s.charAt(i);
			if(seenCharMap.containsKey(ch)) {
				seenCharMap.put(ch, seenCharMap.get(ch) + 1);
			}
			else
			{
				seenCharMap.put(ch, 1);
			}
			
			if(seenCharMap.size() <= k && (i - curBeg + 1 > maxLen)) {
				maxLen = i - curBeg + 1;
			}
			else if(seenCharMap.size() > k) {
				while(seenCharMap.size() > k) {
					char remCh = s.charAt(curBeg);
					seenCharMap.put(remCh, seenCharMap.get(remCh) - 1);
					if (seenCharMap.get(remCh) == 0) {
						seenCharMap.remove(remCh);
					}
					curBeg++;
				}
				
				if(i - curBeg + 1 > maxLen) {
					maxLen = i - curBeg + 1;	
				}
			}
		}
		return maxLen;
	}
}
