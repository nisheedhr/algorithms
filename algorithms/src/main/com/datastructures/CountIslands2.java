package com.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * A 2d grid map of m rows and n columns is initially filled with water. 
 * We may perform an addLand operation which turns the water at position (row, col) into a land. 
 * Given a list of positions to operate, count the number of islands after each addLand operation.
 *  An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 *  You may assume all four edges of the grid are all surrounded by water.

Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
We return the result as an array: [1, 1, 2, 3]

Challenge:

Can you do it in time complexity O(k log mn), where k is the length of the positions?
 * @author nraveend
 *
 */
public class CountIslands2 {

    /**
     * Use union find algorithm.
     * Keep track of numLands and increment it whenever a land is added.
     * Do union in all 4 directions whenever a slot is made land.
     * number of islands = number of lands - number of unions.
     * @param m
     * @param n
     * @param positions
     * @return
     */
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		byte[] grid = new byte[m * n];
		int[] parent = new int[m * n];
		int[] size = new int[m * n];

		for (int i = 0; i < m * n; ++i) {
			parent[i] = i;
			size[i] = 1;
		}

		int numLands = 0;
		int numUnions = 0;
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < positions.length; ++i) {
			int row = positions[i][0];
			int col = positions[i][1];
			int landIndex = n * row + col;
			grid[landIndex] = 1;
			numLands++;
			numUnions += unionLand(row, col - 1, parent, size, grid, m, n, landIndex);
			numUnions += unionLand(row, col + 1, parent, size, grid, m, n, landIndex);
			numUnions += unionLand(row - 1, col, parent, size, grid, m, n, landIndex);
			numUnions += unionLand(row + 1, col, parent, size, grid, m, n, landIndex);
			result.add(numLands - numUnions);
		}

		return result;
	}

	private int unionLand(int row, int col, int[] parent, int[] size, byte[] grid, int m, int n, int landIndex) {
		int union = 0;
		if (row >= 0 && col >= 0 && row < m && col < n && grid[n * row + col] == 1) {
			int newLandIndex = n * row + col;
			union = union(landIndex, newLandIndex, parent, size);
		}
		return union;
	}

	private int union(int landIndex, int newLandIndex, int[] parent, int[] size) {
		int union = 0;
		int pl = find(landIndex, parent);
		int pn = find(newLandIndex, parent);
		if (pl == pn) {
			union = 0;
		} else if (size[pl] < size[pn]) {
			parent[pl] = pn;
			size[pn] += size[pl];
			union = 1;
		} else {
			parent[pn] = pl;
			size[pl] += size[pn];
			union = 1;
		}
		return union;
	}

	private int find(int landIndex, int[] parent) {
		if (landIndex != parent[landIndex]) {
			parent[landIndex] = find(parent[landIndex], parent);
		}
		return parent[landIndex];
	}

}
