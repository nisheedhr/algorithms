package com.graph;

import java.util.PriorityQueue;

/**
 * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map,
 *  compute the volume of water it is able to trap after raining.

Note:
Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

Example:

Given the following 3x6 height map:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

Return 4.
 * @author nraveend
 *
 */
public class TrappingRainWater2 {

  private static class Cell {
    private int row;
    private int col;
    private int height;

    Cell (int row, int col, int height) {
      this.row = row;
      this.col = col;
      this.height = height;
    }
  }
  /**
   *  Start from boundary and move inward. Add all cells to a priority queue
   *  Pop one with min height , compute area and add its neighbors. 
   *  While adding neigbor its height is set as max of current height and neighbor height.
   * @param heightMap
   * @return
   */
  public int trapRainWater(int[][] heightMap) {
    int area = 0;
    if (heightMap.length < 2 || heightMap[0].length < 2) {
      return area;
    }
    
    int m = heightMap.length;
    int n = heightMap[0].length;
    boolean visited[][] = new boolean[m][n];
    PriorityQueue<Cell>  pq = new PriorityQueue<>((f,s) -> f.height - s.height);
    // Add first and last colum cells
    for (int i = 0; i< m; ++i) {
      pq.offer(new Cell(i, 0, heightMap[i][0]));
      visited[i][0] = true;
      pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
      visited[i][n - 1] = true;
    }
    
    // Add first row and last row cells
    for (int i = 1; i<  n -1; ++i) {
      pq.offer(new Cell(0, i, heightMap[0][i]));
      visited[0][i] = true;
      pq.offer(new Cell(m -1, i, heightMap[m - 1][i]));
      visited[m - 1][i] = true;
    }
    
    while  (!pq.isEmpty()) {
      Cell cell = pq.poll();
      area += cell.height - heightMap[cell.row][cell.col];
      addNgbr(cell.row +1, cell.col, cell.height, heightMap, pq, visited);
      addNgbr(cell.row - 1, cell.col, cell.height, heightMap, pq, visited);
      addNgbr(cell.row, cell.col + 1, cell.height, heightMap, pq, visited);
      addNgbr(cell.row, cell.col - 1, cell.height, heightMap, pq, visited);
    }
    return area;
  }
  private void addNgbr(int row, int col, int height, int[][] heightMap, PriorityQueue<Cell> pq, 
      boolean visited[][]) {
    if (row >= 0 && row < heightMap.length && col >= 0 && col < heightMap[0].length && 
        !visited[row][col]) {
      visited[row][col] = true;
      pq.offer(new Cell(row, col, Math.max(height, heightMap[row][col])));
    }
    
  }
}
