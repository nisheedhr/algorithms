package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Find all strobogrammatic numbers that are of length = n.
 * 
 * For example, Given n = 2, return ["11","69","88","96"].
 * 
 * @author nraveend
 *
 */
public class Strobogrammatic {

  public List<String> findStrobogrammatic(int n) {
    List<String> out = new ArrayList<String>();
    if (n != 0) {
      StringBuilder left = new StringBuilder();
      StringBuilder right = new StringBuilder();
      int[][] chars = { {0, 0}, { 1, 1 }, { 8, 8 }, { 6, 9 }, { 9, 6 } };
      buildSB(left, right, out, n, chars);
    }
    return out;
  }

  private void buildSB(StringBuilder left, StringBuilder right, List<String> out, int n, int[][] chars) {
    if (n == 0) {
      if ((left.length() == 1  && right.length() ==0)|| !(left.charAt(0) == '0')) {
        out.add(left.toString() + right.toString());
      }
    } else if (n == 1) {
      for (int i = 0; i < 3; ++i) {
        left.append(chars[i][0]);
        buildSB(left, right, out, n - 1, chars);
        left.deleteCharAt(left.length() - 1);
      }
    } else {
      for (int i = 0; i < chars.length; ++i) {
        left.append(chars[i][0]);
        right.insert(0, chars[i][1]);
        buildSB(left, right, out, n - 2, chars);
        left.deleteCharAt(left.length() - 1);
        right.deleteCharAt(0);
      }
    }
  }

}
