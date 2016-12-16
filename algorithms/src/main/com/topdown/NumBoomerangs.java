package com.topdown;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is
 * a tuple of points (i, j, k) such that the distance between i and j equals the
 * distance between i and k (the order of the tuple matters).
 * 
 * Find the number of boomerangs. You may assume that n will be at most 500 and
 * coordinates of points are all in the range [-10000, 10000] (inclusive).
 * 
 * Example: Input: [[0,0],[1,0],[2,0]]
 * 
 * Output: 2
 * 
 * Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and
 * [[1,0],[2,0],[0,0]] Show Company Tags Show Tags Show Similar Problems
 * 
 * @author nraveend
 *
 */
public class NumBoomerangs {

  public int numberOfBoomerangs(int[][] points) {
    int num = 0;
    if (points == null || points.length == 0) {
      return 0;
    }

    Map<Integer, Integer> lk = new HashMap<>();
    for (int i = 0; i < points.length; ++i) {
      int[] p1 = points[i];
      for (int j = 0; j < points.length; ++j) {
        if (i == j) {
          continue;
        }
        int[] p2 = points[j];
        int ij = (int) (Math.pow(p2[1] - p1[1], 2) + Math.pow(p2[0] - p1[0], 2));
        if (!lk.containsKey(ij)) {
          lk.put(ij, 1);
        } else {
          lk.put(ij, lk.get(ij) + 1);
        }
      }

      for (Integer va : lk.values()) {
        num += va * (va - 1);
      }
      lk.clear();
    }
    return num;
  }
}
