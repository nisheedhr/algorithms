package com.bit;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton 
 * devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts 
with its eight neighbors (horizontal, vertical, diagonal) using the following four rules 
(taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: 
You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. 
In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array.
 How would you address these problems?
 * @author nraveend
 *
 */
public class GameOfLife {

  /**
   * Key idea  Use the first bit to store current value
   * Second bit to store next value
   * In the first loop ,compute next iteration value for every cell.
   * Next iteration do right shift to store only next iteration value.
   * For all checks use & 1 to check current value.
   * @param board
   */
  public void gameOfLife(int[][] board) {
    
    for (int i = 0; i < board.length ; ++i) {
      for (int j = 0; j < board[i].length ; ++j) {
        board[i][j] |= getNextIterationValue(board, i, j);
      }
    }
    
    for (int i = 0; i < board.length ; ++i) {
      for (int j = 0; j < board[i].length ; ++j) {
        board[i][j] = board[i][j] >> 1;
      }
    }
  }

  private int getNextIterationValue(int[][] board, int i, int j) {
    int numLiveNbrs = getNumLive(board, i, j);
    int curValue = board[i][j] & 1;
    
    if (curValue == 1  && (numLiveNbrs < 2 || numLiveNbrs > 3)) {
      return 0;
    } else if (curValue == 1 && (numLiveNbrs ==2 || numLiveNbrs == 3)) {
      return 2;
    } else if (curValue == 0 && numLiveNbrs == 3) {
      return 2;
    }
    return 0;
  }

  private int getNumLive(int[][] board, int row, int col) {
    int numLive = 0;
    //left
    numLive += col - 1 >= 0 ? board[row][col - 1] & 1: 0;
    //right
    numLive += col + 1 < board[row].length ? board[row][col + 1] & 1 : 0;
    //up
    numLive += row - 1 >= 0 ? board[row - 1][col] & 1 : 0;
    //down
    numLive += row + 1 < board.length ? board[row + 1][col ] & 1 : 0;
    //left up diagonal
    numLive += row - 1 >= 0 && col - 1 >= 0 ? board[row -1][col - 1] & 1 : 0;
    //right down diagonal
    numLive += row + 1 < board.length  && col + 1 < board[row].length ? board[row + 1][col + 1] & 1 : 0;
    //right up diagonal
    numLive += row - 1 >= 0  && col + 1 < board[row].length ? board[row - 1][col + 1] & 1 : 0;
    //left down diagonal
    numLive += row + 1  < board.length && col - 1 >= 0 ? board[row + 1][col - 1] & 1 : 0;
    return numLive;
  }
}
