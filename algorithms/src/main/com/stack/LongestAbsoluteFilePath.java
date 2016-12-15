package com.stack;

import java.util.Stack;

/**
 * 
 * suppose we abstract our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system. If there is no file in the system, return 0.

Note:
The name of a file contains at least a . and an extension.
The name of a directory or sub-directory will not contain a ..
Time complexity required: O(n) where n is the size of the input string.

Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
 * @author nraveend
 *
 */
public class LongestAbsoluteFilePath {

	
	/**
	 * Use string split function to split string into array.
	 * Use lastIndeof to find the level.
	 * If level less pop
	 * else if not directory push.
	 * Compute maxlength.
	 * @param input
	 * @return
	 */
	public int lengthLongestPath(String input) {
		if(input == null || input.isEmpty()) {
			return 0;
		}
		Stack<Integer> lenStack = new Stack<Integer>();
		int maxLen =0;
		lenStack.push(0);
		for (String str : input.split("\n")) {
			int level = str.lastIndexOf('\t') + 1;
			while(lenStack.size() > level +1) {
				lenStack.pop();
			}
			int len = str.length() + lenStack.peek() -level + 1;
			lenStack.push(len);
			if(str.contains(".")) {
				maxLen = Math.max(maxLen, len -1);
			}
		}
		return maxLen;
	}
	
	
	private static class Result {
		int maxLen;
		int nextLevl;
		int curPos;
	}
	public int lengthLongestPath1(String input) {
		if(input == null || input.isEmpty()) {
			return 0;
		}
		Result res = new Result();
		res.maxLen = 0;
		res.curPos = 0;
		res.nextLevl = 0;
		computeMaxLen(input, 0, 1, res);
		return res.maxLen;
	}
	private void computeMaxLen(String str, int curLen, int curLevel, Result res) {
		if(res.curPos >= str.length()) {
			return;
		}
		
		int nPos = str.indexOf('\n', res.curPos);
		// For the last entry
		if(nPos == -1) {
			String entry = str.substring(res.curPos);
			if(entry.contains(".")) {
				int curFileLen = curLen + curLevel + entry.length() -1;
				if(curFileLen > res.maxLen) {
					res.maxLen = curFileLen;
				}
			}
			res.curPos = str.length();
			return;
		}
		else {
			String entry = str.substring(res.curPos, nPos);
			nPos++;
			// COmpute the next level
			int nextLevel = 1;
			while(str.charAt(nPos) == '\t') {
				nextLevel++;
				nPos++;
			}
			// Handle file entry
			if(entry.contains(".")) {
				int curFileLen = curLen + curLevel + entry.length() -1;
				if(curFileLen > res.maxLen) {
					res.maxLen = curFileLen;
				}
				res.curPos = nPos;
				res.nextLevl = nextLevel;
				return;
			} else {
				// Handle directory entry  using recursion
				res.nextLevl = nextLevel;
				res.curPos = nPos;
				while(res.nextLevl > curLevel && res.curPos < str.length()) {
					computeMaxLen(str, curLen + entry.length(), res.nextLevl, res);
				}
			}
		}
		
	}
}
