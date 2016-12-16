package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, 
 * the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" 
 * touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height 
equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 * @author nraveend
 *
 */
public class PacificAtlantic {

  /**
   * Key idea is to bfs from both pacific and atlantic.
   * Mark the nodes visited in 2 visit arrays.
   * Return the points which are reachable from both where visited is true in both arrays.
   * @param matrix
   * @return
   */
  public List<int[]> pacificAtlantic(int[][] matrix) {
    List<int[]> result = new ArrayList<>();
    if (matrix != null && matrix.length > 0) {
      Queue<int[]> pacQ = new LinkedList<>();
      Queue<int[]> atQ = new LinkedList<>();
      boolean[][] pacVisited = new boolean[matrix.length][matrix[0].length];
      boolean[][] atVisited = new boolean[matrix.length][matrix[0].length];
      
      for (int row = 0; row < matrix.length ; ++row) {
        pacQ.offer(new int[] {row,0});
        atQ.offer(new int[] {row,matrix[row].length -1});
        pacVisited[row][0] = true;
        atVisited[row][matrix[row].length -1] = true;
      }
      
      for (int col = 1; col < matrix[0].length ; ++col) {
        pacQ.offer(new int[] {0,col});
        atQ.offer(new int[] {matrix.length -1, matrix[0].length - col - 1});
        pacVisited[0][col] = true;
        atVisited[matrix.length -1][matrix[0].length -col -1] = true;
      }
      
      bfs(matrix, pacVisited, pacQ);
      bfs(matrix, atVisited, atQ);
      
      for (int row = 0; row < matrix.length ; ++row) {
        for (int col = 0; col < matrix[row].length ; ++col) {
          if (atVisited[row][col] && pacVisited[row][col]) {
            result.add(new int[] {row, col});
          }
        }
      }
    }
    return result;
  }

  private void bfs(int[][] matrix, boolean[][] pacVisited, Queue<int[]> pacQ) {
   while (!pacQ.isEmpty()) {
     int[] pos = pacQ.poll();
     process(matrix, pacVisited, pacQ, pos[0], pos[1] +1 , matrix[pos[0]][pos[1]]);
     process(matrix, pacVisited, pacQ, pos[0], pos[1] - 1 , matrix[pos[0]][pos[1]]);
     process(matrix, pacVisited, pacQ, pos[0] + 1, pos[1] , matrix[pos[0]][pos[1]]);
     process(matrix, pacVisited, pacQ, pos[0] - 1, pos[1] , matrix[pos[0]][pos[1]]);
   }
    
  }

  private void process(int[][] matrix, boolean[][] pacVisited, Queue<int[]> pacQ, int row, int col, int curVal) {
    if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length || pacVisited[row][col] ||
        curVal > matrix[row][col]) {
      return;
    }
    pacQ.offer(new int[] {row, col});
    pacVisited[row][col] = true;
    
  }
}
