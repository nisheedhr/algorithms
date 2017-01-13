package com.graph;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is 
 * surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume 
 * all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
 * @author nraveend
 *
 */
public class CountNumIslands {

	/**
	 * Paint fill Replace target color with replacement color recursively.
	 * Number of islands is number of times dfs paint fill is called from top level.
	 * @param grid
	 * @return
	 */
    public int numIslands(char[][] grid) {
     int num = 0;
     for(int row = 0; row < grid.length ; ++row) {
    	 for(int col = 0; col < grid[row].length; ++col) {
    		 if(grid[row][col] == '1') {
    			 dfsPaintFill(grid, row, col, '1', '0');
    			 num++;
    		 }
    	 }
     }
     return num;
    }

    /**
     * use the paint fill to recursively fill in the colors
     * @param grid
     * @param row
     * @param col
     * @param targetColor
     * @param repColor
     */
	private void dfsPaintFill(char[][] grid, int row, int col, char targetColor, char repColor) {
		if(row >=0 && row < grid.length && col >= 0 && col < grid[row].length) {
			if(grid[row][col] == targetColor) {
				grid[row][col] = repColor;
				dfsPaintFill(grid, row-1, col, '1', '0'); //North
				dfsPaintFill(grid, row+1, col, '1', '0'); // South
				dfsPaintFill(grid, row, col-1, '1', '0'); //West
				dfsPaintFill(grid, row, col+1, '1', '0'); //East
			}
		}
		
	}
}
