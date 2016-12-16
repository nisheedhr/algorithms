package com.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Suppose you have a random list of people standing in a queue. Each person is described by a 
 * pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person 
 * who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * @author nraveend
 *
 */
public class QueueRestructure {

  
  /**
   * Sort in descending order of height. 
   * If heights are same, sort in ascending order of number. 
   * Insert them into output using a list by inserting at position based on the number.
   * @param people
   * @return
   */
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (first, second) -> first[0] != second[0] ? Integer.compare(second[0], first[0]) :
      Integer.compare(first[1], second[1]));
    
    List<int[]> Persons = new ArrayList<>();
    for (int i = 0; i < people.length; ++i) {
      Persons.add(people[i][1], people[i]);
    }
    
    return Persons.toArray(new int[people.length][]);
  }
  /**
   * Use recursive backtracking to arrive at solution . Won't work for large arrays
   * because of oh(n!) complexity.
   * @param people
   * @return
   */
  public int[][] reconstructQueue2(int[][] people) {
    int[][] out = new int [people.length][people[0].length];
    boolean[] visited = new boolean[people.length];
    Arrays.sort(people, new Comparator<int[]>() {

      @Override
      public int compare(int[] o1, int[] o2) {
        int val = o1[1] - o2[1];
        
        return val == 0 ? o1[0] - o2[0] : val;
      }
    });
    
    findSolution(0, people, out, visited);
    return out;
  }

  private boolean findSolution(int pos, int[][] people, int[][] out, boolean[] visited) {
    if (pos == out.length) {
      return true;
    }
    
    boolean foundSolution = false;
    for (int i = 0; i < people.length; ++i) {
      if (!visited[i] && canVisit(people[i], out, pos)) {
        visited[i] = true;
        out[pos][0] = people[i][0];
        out[pos][1] = people[i][1];
        foundSolution = findSolution(pos + 1, people, out, visited);
        if (foundSolution) {
          break;
        } else {
          visited[i] = false;
          out[pos][0] = 0;
          out[pos][1] = 0;
        }
      }
    }
    return foundSolution;
    
  }

  private boolean canVisit(int[] input, int[][] out, int pos) {
    if (pos < input[1]) {
      return false;
    }
    
    //return Arrays.stream(out, 0, pos).filter(val -> val[0] >= input[0]).count() == input[1];
    boolean visit = true;
    int num = 0;
    for (int i = 0 ; i < pos ; ++i) {
      if(out[i][0] >= input[0]) {
        num++;
        
        if (num > input[1]) {
          visit = false;
          break;
        }
      }
    }
    return visit && num == input[1];
  }
}
