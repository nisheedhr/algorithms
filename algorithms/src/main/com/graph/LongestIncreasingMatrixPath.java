package com.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an integer matrix, find the length of the longest increasing path.
 * 
 * From each cell, you can either move to four directions: left, right, up or
 * down. You may NOT move diagonally or move outside of the boundary (i.e.
 * wrap-around is not allowed).
 * 
 * Example 1:
 * 
 * nums = [ [9,9,4], [6,6,8], [2,1,1] ] Return 4 The longest increasing path is
 * [1, 2, 6, 9].
 * 
 * Example 2:
 * 
 * nums = [ [3,4,5], [3,2,6], [2,2,1] ] Return 4 The longest increasing path is
 * [3, 4, 5, 6]. Moving diagonally is not allowed.
 * 
 * @author nraveend
 *
 */
public class LongestIncreasingMatrixPath {

  /**
   * Key idea is to start from smallest number and find maxLen. Use DP to store
   * all adjacent paths as well. Return max of all paths.
   * Use a priority queue to store the cell value.
   * Compute the max length for each entry in priority queue by caching.
   * For a cell max value is  1 + max (left, right, up, down);
   * 
   * @param matrix
   * @return
   */
  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }

    Map<Integer, Integer> lenMap = new HashMap<>();
    PriorityQueue<int[]> pq = new PriorityQueue<>((f, s) -> f[2] - s[2]);
    for (int row = 0; row < matrix.length; ++row) {
      for (int col = 0; col < matrix[row].length; ++col) {
        pq.offer(new int[] { row, col, matrix[row][col] });
      }
    }

    int maxLen = 0;
    Integer prev = null;
    while (!pq.isEmpty()) {
      int pos[] = pq.poll();
      int len = computeMaxLen(pos[0], pos[1], lenMap, matrix, prev);
      if (len > maxLen) {
        maxLen = len;
      }
    }
    return maxLen;
  }

  private int computeMaxLen(int row, int col, Map<Integer, Integer> lenMap, int[][] matrix, Integer prev) {
    if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length
        || (prev != null && matrix[row][col] <= prev)) {
      return 0;
    }
    int pos = getPos(row, col, matrix);
    if (lenMap.containsKey(pos)) {
      return lenMap.get(pos);
    }
    int l = computeMaxLen(row, col - 1, lenMap, matrix, matrix[row][col]);
    int r = computeMaxLen(row, col + 1, lenMap, matrix, matrix[row][col]);
    int u = computeMaxLen(row - 1, col, lenMap, matrix, matrix[row][col]);
    int d = computeMaxLen(row + 1, col, lenMap, matrix, matrix[row][col]);
    lenMap.put(pos, 1 + Math.max(Math.max(l, r), Math.max(u, d)));
    return lenMap.get(pos);
  }

  private int getPos(int row, int col, int[][] matrix) {
    return row * matrix[row].length + col;
  }
}
