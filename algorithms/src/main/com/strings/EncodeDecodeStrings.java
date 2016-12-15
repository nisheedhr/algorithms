package com.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a string. The encoded
 * string is then sent over the network and is decoded back to the original list
 * of strings.
 * 
 * Machine 1 (sender) has the function:
 * 
 * string encode(vector<string> strs) { // ... your code return encoded_string;
 * } Machine 2 (receiver) has the function: vector<string> decode(string s) {
 * //... your code return strs; } So Machine 1 does:
 * 
 * string encoded_string = encode(strs); and Machine 2 does:
 * 
 * vector<string> strs2 = decode(encoded_string); strs2 in Machine 2 should be
 * the same as strs in Machine 1.
 * 
 * Implement the encode and decode methods.
 * 
 * Note: The string may contain any possible characters out of 256 valid ascii
 * characters. Your algorithm should be generalized enough to work on any
 * possible characters. Do not use class member/global/static variables to store
 * states. Your encode and decode algorithms should be stateless. Do not rely on
 * any library method such as eval or serialize methods. You should implement
 * your own encode/decode algorithm.
 * 
 * @author nraveend
 *
 */
public class EncodeDecodeStrings {

	/**
	 * Encode length of array followed by _ length of each string_ followed by string
	 * @param chars
	 * @return
	 */
	public String encode(List<String> chars) {
		StringBuilder sb = new StringBuilder(chars.size() * 32);
		sb.append(chars.size());
		sb.append('_');
		for (String str : chars) {
			sb.append(str.length());
			sb.append('_');
			if (!str.isEmpty()) {
				sb.append(str);
				sb.append('_');
			}
		}
		return sb.toString();
	}

	public List<String> decode(String s) {
		List<String> result = new ArrayList<>();
		int index = s.indexOf('_');
		if (index != -1) {
			int numStrings = Integer.parseInt(s.substring(0, index));
			index += 1;
			for (int i = 0; i < numStrings; ++i) {
				int nexUnd = s.indexOf('_', index);
				if (nexUnd != -1) {
					int strLen = Integer.parseInt(s.substring(index, nexUnd));
					index = nexUnd + 1;
					if (strLen != 0) {
						String str = s.substring(index, index + strLen);
						result.add(str);
						index = index + strLen + 1;
					} else {
						result.add("");
					}
				} else {
					break;
				}
			}
		}
		return result;
	}
}
