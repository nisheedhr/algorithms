package com.stack;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * @author nisheedh
 *
 */
public class ValidParenthesis {

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        boolean valid = true;
        Stack<Character> cs = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                cs.push(ch);
            } else {
                if (cs.isEmpty()) {
                    valid = false;
                    break;
                }
                char other = cs.pop();
                if ((ch == ')' && other != '(') || (ch == ']' && other != '[') || (ch == '}' && other != '{')) {
                    valid = false;
                    break;
                }
            }
        }
        if (valid) {
            valid = cs.isEmpty();
        }
        return valid;
    }
}
