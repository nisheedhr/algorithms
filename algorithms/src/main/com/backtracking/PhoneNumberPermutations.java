package com.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @author nisheedh
 *
 */
public class PhoneNumberPermutations {

    public List<String> letterCombinations(String digits) {
        List<String> out = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Map<Character, char[]> charMap = new HashMap<>();
        charMap.put('2', new char[]{'a', 'b', 'c'});
        charMap.put('3', new char[]{'d', 'e', 'f'});
        charMap.put('4', new char[]{'g', 'h', 'i'});
        charMap.put('5', new char[]{'j', 'k', 'l'});
        charMap.put('6', new char[]{'m', 'n', 'o'});
        charMap.put('7', new char[]{'p', 'q', 'r', 's'});
        charMap.put('8', new char[]{'t', 'u', 'v'});
        charMap.put('9', new char[]{'w', 'x', 'y', 'z'});
        int pos = 0;
        if (!digits.isEmpty()) {
            buildStringPerm(sb, out, digits, pos, charMap);
        }
        return out;
    }

    private void buildStringPerm(StringBuilder sb, List<String> out, String digits, int pos,
            Map<Character, char[]> charMap) {
        if (pos == digits.length()) {
            out.add(sb.toString());
            return;
        }
        
        for (char ch : charMap.get(digits.charAt(pos))) {
            sb.append(ch);
            buildStringPerm(sb, out, digits, pos + 1, charMap);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
