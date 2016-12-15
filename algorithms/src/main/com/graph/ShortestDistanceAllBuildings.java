package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * You want to build a house on an empty land which reaches all buildings in the
 * shortest amount of distance. You can only move up, down, left and right. You
 * are given a 2D grid of values 0, 1 or 2, where:
 * 
 * Each 0 marks an empty land which you can pass by freely. Each 1 marks a
 * building which you cannot pass through. Each 2 marks an obstacle which you
 * cannot pass through. For example, given three buildings at (0,0), (0,4),
 * (2,2), and an obstacle at (0,2):
 * 
 * 1 - 0 - 2 - 0 - 1 | | | | | 0 - 0 - 0 - 0 - 0 | | | | | 0 - 0 - 1 - 0 - 0 The
 * point (1,2) is an ideal empty land to build a house, as the total travel
 * distance of 3+3+1=7 is minimal. So return 7.
 * 
 * Note: There will be at least one building. If it is not possible to build
 * such house according to the above rules, return -1.
 * 
 * @author nraveend
 *
 */
public class ShortestDistanceAllBuildings {

	private static class Position {
		int row;
		int col;
		int dist;

		Position(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}

	/**
	 * Do BFS from all the empty plots
	 * Choose the min value which visits all the houses.
	 * @param grid
	 * @return
	 */
	public int shortestDistance(int[][] grid) {
		int shortDist = Integer.MAX_VALUE;

		List<Position> houses = getHouses(grid);
		// map from empty plot to all houses
		Map<Integer, Map<Integer, Integer>> emptyHouseMap = new HashMap<>();
		for (Position house : houses) {
			computeShortestDistance(house, grid, emptyHouseMap);
		}

		for (Map.Entry<Integer, Map<Integer, Integer>> emptyHouse : emptyHouseMap.entrySet()) {
			if (emptyHouse.getValue().size() == houses.size()) {
				int housesDist = 0;
				for (Integer value : emptyHouse.getValue().values()) {
					housesDist += value;
				}
				if (housesDist < shortDist) {
					shortDist = housesDist;
				}
			}
		}

		if (shortDist == Integer.MAX_VALUE) {
			shortDist = -1;
		}
		return shortDist;
	}

	/**
	 * doesn't work for
	 * 1 0
	 * 0 1
	 * @param grid
	 * @return
	 */
	public int shortestDistance2(int[][] grid) {
		int[][] nodeIds = new int[grid.length][];
		for (int row = 0; row < grid.length; ++row) {
			nodeIds[row] = new int[grid[row].length];
		}

		int row = 0;
		int col = 0;
		boolean hasHouse = false;

		outerloop: for (row = 0; row < grid.length; ++row) {
			for (col = 0; col < grid[row].length; ++col) {
				if (grid[row][col] == 1) {
					hasHouse = true;
					break outerloop;
				}
			}
		}

		if (hasHouse) {
			List<Integer> houseNodeIds = new ArrayList<>();
			bfsHouse(row, col, grid, nodeIds, houseNodeIds);
			return minSum(grid, nodeIds, houseNodeIds);
		} else {
			return -1;
		}
	}

	int minSum(int[][] grid, int[][] nodeIds, List<Integer> houseNodeIds) {

		int shortDist = Integer.MAX_VALUE;

		for (int row = 0; row < grid.length; ++row) {
			for (int col = 0; col < grid[row].length; ++col) {
				if (grid[row][col] == 0) {
					int nodeId = nodeIds[row][col];
					int sum = 0;
					sum += houseNodeIds.stream().filter(id -> id > nodeId).mapToInt(i -> i.intValue()).sum();
					int higherHouses = (int) houseNodeIds.stream().filter(id -> id > nodeId).count();
					sum -= higherHouses * nodeId;
					sum += (houseNodeIds.size() - higherHouses) * (nodeId - 1);
					if (sum < shortDist) {
						shortDist = sum;
					}
				}
			}
		}

		if (shortDist == Integer.MAX_VALUE) {
			shortDist = -1;
		}
		return shortDist;
	}

	private void bfsHouse(int row, int col, int[][] grid, int[][] nodeIds, List<Integer> houseNodeIds) {
		nodeIds[row][col] = 1;
		houseNodeIds.add(nodeIds[row][col]);
		Queue<Integer> bfsQueue = new LinkedList<>();
		bfsQueue.add(row * grid[0].length + col);
		while (!bfsQueue.isEmpty()) {
			int pos = bfsQueue.poll();
			row = pos / grid[0].length;
			col = pos % grid[0].length;
			processNeighbour2(row, col + 1, grid, nodeIds, nodeIds[row][col] + 1, houseNodeIds, bfsQueue);
			processNeighbour2(row, col - 1, grid, nodeIds, nodeIds[row][col] + 1, houseNodeIds, bfsQueue);
			processNeighbour2(row + 1, col, grid, nodeIds, nodeIds[row][col] + 1, houseNodeIds, bfsQueue);
			processNeighbour2(row - 1, col, grid, nodeIds, nodeIds[row][col] + 1, houseNodeIds, bfsQueue);
		}
	}

	private void processNeighbour2(int row, int col, int[][] grid, int[][] nodeIds, int dist,
			List<Integer> houseNodeIds, Queue<Integer> bfs) {
		if (col < 0 || row < 0 || row >= grid.length || col >= grid[row].length) {
			return;
		} else if (grid[row][col] == 2) {
			return;
		}
		// visited node ids
		else if (nodeIds[row][col] != 0) {
			return;
		} else if (grid[row][col] == 1) {
			nodeIds[row][col] = dist ;
			houseNodeIds.add(dist);
			return;
		} else if (grid[row][col] == 0) {
			nodeIds[row][col] = dist ;
			bfs.offer(row * grid[0].length + col);
		}

	}

	private void computeShortestDistance(Position house, int[][] grid,
			Map<Integer, Map<Integer, Integer>> emptyHouseMap) {
		Queue<Position> bfs = new LinkedList<>();
		int[][] visited = new int[grid.length][];
		for (int row = 0; row < grid.length; ++row) {
			visited[row] = new int[grid[row].length];
		}
		visited[house.row][house.col] = 1;
		int housId = house.col;
		for (int j = 0; j < house.row; ++j) {
			housId += grid[house.row].length;
		}

		bfs.offer(house);
		while (!bfs.isEmpty()) {
			Position pos = bfs.poll();
			processNeighbour(pos.row, pos.col - 1, pos.dist, emptyHouseMap, grid, visited, bfs, housId);
			processNeighbour(pos.row, pos.col + 1, pos.dist, emptyHouseMap, grid, visited, bfs, housId);
			processNeighbour(pos.row + 1, pos.col, pos.dist, emptyHouseMap, grid, visited, bfs, housId);
			processNeighbour(pos.row - 1, pos.col, pos.dist, emptyHouseMap, grid, visited, bfs, housId);
		}

	}

	private void processNeighbour(int row, int col, int dist, Map<Integer, Map<Integer, Integer>> emptyHouseMap,
			int[][] grid, int[][] visited, Queue<Position> bfs, int housId) {

		if (col < 0 || row < 0 || row >= grid.length || col >= grid[row].length) {
			return;
		} else if (grid[row][col] == 2 || grid[row][col] == 1) {
			return;
		} else if (visited[row][col] == 1) {
			return;
		} else if (grid[row][col] == 0) {
			int plotId = col;
			for (int j = 0; j < row; ++j) {
				plotId += grid[row].length;
			}

			visited[row][col] = 1;
			bfs.offer(new Position(row, col, dist + 1));
			if (emptyHouseMap.containsKey(plotId)) {
				emptyHouseMap.get(plotId).put(housId, dist + 1);
			} else {
				Map<Integer, Integer> houseMap = new HashMap<>();
				houseMap.put(housId, dist + 1);
				emptyHouseMap.put(plotId, houseMap);
			}
		}

	}

	private List<Position> getHouses(int[][] grid) {
		List<Position> houses = new ArrayList<>();
		for (int row = 0; row < grid.length; ++row) {
			for (int col = 0; col < grid[row].length; ++col) {
				if (grid[row][col] == 1) {
					houses.add(new Position(row, col, 0));
				}
			}
		}
		return houses;
	}

}
