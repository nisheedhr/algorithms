package com.graph;

/**
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero),
 *  return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall 
since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.

Example:
For the given grid

0 E 0 0
E 0 W E
0 E 0 0

return 3. (Placing a bomb at (1,1) kills 3 enemies)
Credits:
 * @author nraveend
 *
 */
public class BombEnemy {

	/**
	 * Compute the number of enemies which can be killed for each empty cell and return the max value.
	 * For each cell compute the enemies which can be killed in all 4 directions.
	 * @param grid
	 * @return
	 */
    public int maxKilledEnemies(char[][] grid) {
    	int max = 0;
    	for(int i = 0; i < grid.length ; ++i) {
    		for(int j = 0; j < grid[i].length; ++j) {
    			if(grid[i][j] == '0') {
    				int numKill = left(i,j, grid) + right(i,j, grid) + up(i,j, grid) + down(i,j, grid);
    				if(numKill > max) {
    					max = numKill;
    				}
    			}
    		}
    	}
    	return max;
    }

	private int down(int i, int j, char[][] grid) {
		int num = 0;
		while(++i < grid.length) {
			if(grid[i][j] == 'E'){
				num++;
			}
			else if(grid[i][j] == 'W'){
				break;
			}
		}
		return num;
	}

	private int up(int i, int j, char[][] grid) {
		int num = 0;
		while(--i >= 0) {
			if(grid[i][j] == 'E'){
				num++;
			}
			else if(grid[i][j] == 'W'){
				break;
			}
		}
		return num;
	}

	private int right(int i, int j, char[][] grid) {
		int num = 0;
		while(++j < grid[i].length) {
			if(grid[i][j] == 'E'){
				num++;
			}
			else if(grid[i][j] == 'W'){
				break;
			}
		}
		return num;
	}

	private int left(int i, int j, char[][] grid) {
		int num = 0;
		while(--j >= 0) {
			if(grid[i][j] == 'E'){
				num++;
			}
			else if(grid[i][j] == 'W'){
				break;
			}
		}
		return num;
	}
}
