package com.strings;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

Show Company Tags

 * @author nisheedh
 *
 */
public class UniqueCharInString {

    /**
     * Use 2 char hash maps to keep track of character counts and position
     * in second iteration pick a character count with 1 and minimum position.
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int minPos = Integer.MAX_VALUE;
        int count[] = new int[26];
        int charPos[] = new int[26];
        
        for (int i = 0; i < s.length() ; ++i) {
            char ch = s.charAt(i);
            int pos = ch - 'a';
            count[pos] = count[pos] + 1;
            charPos[pos] = i;
        }
        
        for (int i = 0; i < count.length; ++i){
            if (count[i] == 1 && charPos[i] < minPos) {
                minPos = charPos[i];
            }
        }
        return (minPos == Integer.MAX_VALUE ? -1 : minPos);
    }
}
