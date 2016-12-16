package com.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 * 
 * -1 - A wall or an obstacle. 0 - A gate. INF - Infinity means an empty room.
 * We use the value 231 - 1 = 2147483647 to represent INF as you may assume that
 * the distance to a gate is less than 2147483647. Fill each empty room with the
 * distance to its nearest gate. If it is impossible to reach a gate, it should
 * be filled with INF.
 * 
 * For example, given the 2D grid: INF -1 0 INF INF INF INF -1 INF -1 INF -1 0
 * -1 INF INF After running your function, the 2D grid should be: 3 -1 0 1 2 2 1
 * -1 1 -1 2 -1 0 -1 3 4
 * 
 * @author nraveend
 *
 */
public class WallsAndGates {

  /**
   * Key idea - Use bfs from all gates to rooms and use the miniumum value. Do
   * parallely by adding all gates to queue initially. This will ensure that all
   * adjacent rooms are discovered parallely.
   * 
   * @param rooms
   */
  public void wallsAndGates(int[][] rooms) {
    Queue<Integer> bfsQueue = new LinkedList<>();

    for (int row = 0; row < rooms.length; ++row) {
      for (int col = 0; col < rooms[row].length; ++col) {
        if (rooms[row][col] == 0) {
          bfsQueue.offer(row * rooms[row].length + col);
        }
      }
    }

    bfsVisit(rooms, bfsQueue);
  }

  private void bfsVisit(int[][] rooms, Queue<Integer> bfsQueue) {

    while (!bfsQueue.isEmpty()) {
      int curPos = bfsQueue.poll();
      int curRow = curPos / rooms[0].length;
      int curCol = curPos % rooms[0].length;
      visit(curRow, curCol - 1, rooms, bfsQueue, rooms[curRow][curCol]);
      visit(curRow, curCol + 1, rooms, bfsQueue, rooms[curRow][curCol]);
      visit(curRow - 1, curCol, rooms, bfsQueue, rooms[curRow][curCol]);
      visit(curRow + 1, curCol, rooms, bfsQueue, rooms[curRow][curCol]);
    }

  }

  private void visit(int curRow, int curCol, int[][] rooms, Queue<Integer> bfsQueue, int curDist) {
    if (curRow < 0 || curRow >= rooms.length || curCol < 0 || curCol >= rooms[curRow].length
        || rooms[curRow][curCol] == -1 || rooms[curRow][curCol] != Integer.MAX_VALUE) {
      return;
    }
    rooms[curRow][curCol] = curDist + 1;
    bfsQueue.offer(curRow * rooms[curRow].length + curCol);
  }
}
