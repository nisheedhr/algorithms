package com.backtracking;

/**
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤
 * n ≤ 9, count the total number of unlock patterns of the Android lock screen,
 * which consist of minimum of m keys and maximum n keys.
 * 
 * Rules for a valid pattern: Each pattern must connect at least m keys and at
 * most n keys. All the keys must be distinct. If the line connecting two
 * consecutive keys in the pattern passes through any other keys, the other keys
 * must have previously selected in the pattern. No jumps through non selected
 * key is allowed. The order of keys used matters.
 * 
 * | 1 | 2 | 3 | | 4 | 5 | 6 | | 7 | 8 | 9 | Invalid move: 4 - 1 - 3 - 6 Line 1
 * - 3 passes through key 2 which had not been selected in the pattern.
 * 
 * Invalid move: 4 - 1 - 9 - 2 Line 1 - 9 passes through key 5 which had not
 * been selected in the pattern.
 * 
 * Valid move: 2 - 4 - 1 - 3 - 6 Line 1 - 3 is valid because it passes through
 * key 2, which had been selected in the pattern
 * 
 * Valid move: 6 - 5 - 4 - 1 - 9 - 2 Line 1 - 9 is valid because it passes
 * through key 5, which had been selected in the pattern.
 * 
 * Example: Given m = 1, n = 1, return 9.
 * 
 * @author nraveend
 *
 */
public class AndroidLockPatterns {

  /**
   * Key idea is to compute the values for one corner, middle and one top
   * middle. Using symmetry values for all other cells can be computed.
   * 
   * @param m
   * @param n
   * @return
   */
  public int numberOfPatterns(int m, int n) {
    int total = 0;
    boolean[] visited = new boolean[9];
    for (int numKeys = m; numKeys <= n; ++numKeys) {
      int prev = 0;
      visited[prev] = true;
      int numNodesVisited = 1;
      total += 4 * visit(prev, visited, numKeys, numNodesVisited);
      visited[prev] = false;
      
      prev = 1;
      visited[prev] = true;
      total += 4 * visit(prev, visited, numKeys, numNodesVisited);
      visited[prev] = false;
      
      //Visit middle element
      prev = 4;
      visited[prev] = true;
      total += visit(prev, visited, numKeys, numNodesVisited);
      visited[prev] = false;
    }
    return total;
  }

  private int visit(int prev, boolean[] visited, int numKeys, int numNodesVisited) {
    if (numKeys == numNodesVisited) {
      return 1;
    }
    
    int total = 0;
    
    for (int i = 0; i < 9; ++i) {
      if (canVisit(i, prev, visited)) {
        visited[i] = true;
        total += visit(i, visited, numKeys, numNodesVisited + 1);
        visited[i] = false;
      }
    }
    return total;
  }

  private boolean canVisit(int to, int from, boolean[] visited) {
    if (visited[to]) {
      return false;
    } else if ((from + to) % 2 == 1) { // handle adjacent and knights . sum will be odd 0-1, 1-4, 0-7
      return true;
    }
    
    //find lines passing through middle.
    int mid = (from + to) / 2;
    if (mid == 4) {
      return visited[mid];
      // Handle all diagonals . Check if entries are on adjacent rows
    } else if (Math.abs(from % 3 - to % 3) == 1) {
      return true;
    }
    // Handle all other cases
    return visited[mid];
  }

}
