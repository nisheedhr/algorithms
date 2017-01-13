package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: 
 * + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no 
 * longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list [].
 * @author nisheedh
 *
 */
public class FlipGamePerm {

    public List<String> generatePossibleNextMoves(String s) {
      List<String> out = new ArrayList<>();
      if (s != null && !s.isEmpty()) {
    	  StringBuilder sb = new StringBuilder(s);
    	  char prev = sb.charAt(0);
    	  for (int i = 1; i < sb.length(); ++i) {
    		  if (prev == '+' && sb.charAt(i) == '+') {
    			  sb.setCharAt(i, '-');
    			  sb.setCharAt(i - 1, '-');
    			  out.add(sb.toString());
    			  sb.setCharAt(i, '+');
    			  sb.setCharAt(i - 1, '+');
    		  }
    		  prev = sb.charAt(i);
    	  }
      }
      return out;
    }
}
