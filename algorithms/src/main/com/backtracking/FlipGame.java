package com.backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: 
 * + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no
 *  longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
Derive your algorithm's runtime complexity.
 * @author nisheedh
 *
 */
public class FlipGame {

	/**
	 * Key idea is make to sure that opponent cannot win the game.
	 * After self move , my winning strategy is !canWin
	 * @param s
	 * @return
	 */
    public boolean canWin(String s) {
        Map<String, Boolean> winMap = new HashMap<>();
        return canWin(new StringBuilder(s), winMap);
    }

	private boolean canWin(StringBuilder sb, Map<String, Boolean> winMap) {
		if (winMap.containsKey(sb.toString())) {
			return winMap.get(sb.toString());
		}
		
		for (int i = 0; i < sb.length() - 1 ; ++i) {
			if (sb.charAt(i) == '+' && sb.charAt(i+1) =='+') {
				sb.setCharAt(i, '-');
				sb.setCharAt(i+ 1, '-');
				boolean win = !canWin(sb, winMap);
				sb.setCharAt(i, '+');
				sb.setCharAt(i+ 1, '+');
				if (win) {
					winMap.put(sb.toString(), true);
					return true;
				}
			}
		}
		winMap.put(sb.toString(), false);
		return false;
	}
}
