package com.strings;

/**
 * Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated 
exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those 
repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * @author nraveend
 *
 */
public class DecodeString {

	/**
	 * Better solution is to use stack and traverse from back to
	 * first.
	 * @param s
	 * @return
	 */
	public String decodeString(String s) {
		StringBuilder sb = new StringBuilder();
		int pos = 0;
		while (pos < s.length()) {
			pos = getDecodedString(s, pos, sb);
			pos++;
		}

		return sb.toString();
	}

	int getDecodedString(String str, int pos, StringBuilder sb) {

		while (pos < str.length() && str.charAt(pos) != ']') {
			if (Character.isDigit(str.charAt(pos))) {
				int start = pos;
				while (Character.isDigit(str.charAt(pos))) {
					pos++;
				}

				int num = Integer.parseInt(str.substring(start, pos));
				StringBuilder sbNew = new StringBuilder();
				pos = getDecodedString(str, pos, sbNew);
				for (int i = 0; i < num; ++i) {
					sb.append(sbNew.toString());
				}
				pos++;
			} else if (str.charAt(pos) == '[') {
				pos++;
			} else {
				sb.append(str.charAt(pos));
				pos++;
			}
		}
		return pos;
	}
}
