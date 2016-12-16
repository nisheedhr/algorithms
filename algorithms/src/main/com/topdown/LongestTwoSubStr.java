package com.topdown;

/**
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = �eceba�,

T is "ece" which its length is 3.
 * @author nraveend
 *
 */
public class LongestTwoSubStr {

  /**
   * Key idea is find max of longest substring in one direction by keeping track of pointer
   * @param s
   * @return
   */
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int maxLen = 0;
		maxLen = longestSubstring(s, maxLen);
		return maxLen;
		// return Math.max(longestSubstring( new
		// StringBuilder(s).reverse().toString(), maxLen), maxLen);
	}

	/**
	 * Maintain last positions of current 2 characters
	 * On encountering a new character, adjust the length   using last 2 positions.
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstringTwoDistinctNew(String s) {
		int maxLen = 0;
		int curLen = 0;
		char[] curChars = { ' ', ' ' };
		int[] pos = { 0, 0 };
		for (int i = 0; i < s.length(); ++i) {
			if (curLen == 0) {
				curChars[0] = s.charAt(i);
				curLen++;
			} else if (curChars[1] == ' ' && s.charAt(i) != curChars[0]) {
				curChars[1] = s.charAt(i);
				pos[1] = i;
				curLen++;
			} else if (s.charAt(i) == curChars[0]) {
				pos[0] = i;
				curLen++;
			} 
			else if (s.charAt(i) == curChars[1]) {
				curLen++;
				pos[1] = i;
			} else {
				int curBeg = 0;
				if (s.charAt(i - 1) == curChars[0]) {
					curBeg = pos[1] + 1;
				} else
				{
					curBeg = pos[0] + 1;
				}
				curLen = i - curBeg + 1;
				curChars[0] = s.charAt(i - 1);
				curChars[1] = s.charAt(i);
				pos[0] = i -1;
				pos[1] = i;
			}
			if (curLen > maxLen) {
				maxLen = curLen;
			}
		}
		return maxLen;
	}

	private int longestSubstring(String s, int maxLen) {
		int curLen = 0;
		char[] curChars = { ' ', ' ' };
		for (int i = 0; i < s.length(); ++i) {
			if (curLen == 0) {
				curChars[0] = s.charAt(i);
				curLen++;
			} else if (curChars[1] == ' ' && s.charAt(i) != curChars[0]) {
				curChars[1] = s.charAt(i);
				curLen++;
			} else if (s.charAt(i) == curChars[0] || s.charAt(i) == curChars[1]) {
				curLen++;
			} else {
				curChars[0] = s.charAt(i - 1);
				curChars[1] = s.charAt(i);
				curLen = 2;
				int j = i - 2;
				while (j >= 0 && s.charAt(j) == curChars[0]) {
					curLen++;
					j--;
				}
			}

			if (curLen > maxLen) {
				maxLen = curLen;
			}
		}
		return maxLen;
	}
}
