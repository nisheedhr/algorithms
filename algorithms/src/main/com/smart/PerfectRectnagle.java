package com.smart;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Given N axis-aligned rectangles where N > 0, determine if they all together
 * form an exact cover of a rectangular region.
 * 
 * Each rectangle is represented as a bottom-left point and a top-right point.
 * For example, a unit square is represented as [1,1,2,2]. (coordinate of
 * bottom-left point is (1, 1) and top-right point is (2, 2)).
 * 
 * 
 * Example 1:
 * 
 * rectangles = [ [1,1,3,3], [3,1,4,2], [3,2,4,4], [1,3,2,4], [2,3,3,4] ]
 * 
 * Return true. All 5 rectangles together form an exact cover of a rectangular
 * region.
 * 
 * Example 2:
 * 
 * rectangles = [ [1,1,2,3], [1,3,2,4], [3,1,4,2], [3,2,4,4] ]
 * 
 * Return false. Because there is a gap between the two rectangular regions.
 * 
 * Example 3:
 * 
 * rectangles = [ [1,1,3,3], [3,1,4,2], [1,3,2,4], [3,2,4,4] ]
 * 
 * Return false. Because there is a gap in the top center.
 * 
 * Example 4:
 * 
 * rectangles = [ [1,1,3,3], [3,1,4,2], [1,3,2,4], [2,2,4,4] ]
 * 
 * Return false. Because two of the rectangles overlap with each other.
 * 
 * @author nraveend
 *
 */
public class PerfectRectnagle {

  /**
   * Compute the total area and compare with max area. All four corners should
   * have only point. Rest all points should have even entries.
   * 
   * @param rectangles
   * @return
   */
  public boolean isRectangleCover(int[][] rectangles) {
    int minX = Integer.MAX_VALUE;
    int minY = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE;
    int maxY = Integer.MIN_VALUE;

    int area = 0;
    Set<String> points = new HashSet<>();
    for (int[] rect : rectangles) {
      minX = Math.min(minX, rect[0]);
      minY = Math.min(minY, rect[1]);
      maxX = Math.max(maxX, rect[2]);
      maxY = Math.max(maxY, rect[3]);

      area += (rect[2] - rect[0]) * (rect[3] - rect[1]);

      String s0 = rect[0] + " " + rect[1];
      String s1 = rect[2] + " " + rect[1];
      String s2 = rect[0] + " " + rect[3];
      String s3 = rect[2] + " " + rect[3];

      if (!points.add(s0)) {
        points.remove(s0);
      }
      
      if (!points.add(s1)) {
        points.remove(s1);
      }
      
      if (!points.add(s2)) {
        points.remove(s2);
      }
      
      if (!points.add(s3)) {
        points.remove(s3);
      }
    }

    return (area == (maxX - minX) * (maxY - minY)) && points.size() == 4 &&
        points.contains(minX + " " + minY) && points.contains(minX + " " + maxY) &&
        points.contains(maxX + " " + minY) && points.contains(maxX + " " + minY);
  }

  /**
   * Find the maximum x and y for the perfect rectnagle. Sort the input array by
   * x an y. Now build the rectnagle from left to right and bottom to up. use a
   * priority queue for next start position. If next start position doesn't
   * match the priority queue begin retunr false
   * 
   * @param rectangles
   * @return
   */
  public boolean isRectangleCoverOld(int[][] rectangles) {
    boolean perfect = true;
    int maxX = Integer.MIN_VALUE;
    int maxY = Integer.MIN_VALUE;

    for (int rect[] : rectangles) {
      if (rect[2] > maxX) {
        maxX = rect[2];
      }

      if (rect[3] > maxY) {
        maxY = rect[3];
      }
    }

    Arrays.sort(rectangles, (f, s) -> f[0] != s[0] ? f[0] - s[0] : f[1] - s[1]);
    PriorityQueue<int[]> np = new PriorityQueue<>((f, s) -> f[0] != s[0] ? f[0] - s[0] : f[1] - s[1]);
    boolean first = true;
    for (int rect[] : rectangles) {
      if (first && np.isEmpty()) {
        first = false;
        if (rect[2] < maxX) {
          np.offer(new int[] { rect[2], rect[1] });
        }

        if (rect[3] < maxY) {
          np.offer(new int[] { rect[0], rect[3] });
        }
      } else if (np.isEmpty()) {
        perfect = false;
        break;
      } else if (rect[0] == np.peek()[0] && rect[1] == np.peek()[1]) {
        np.poll();
        if (rect[2] < maxX) {
          np.offer(new int[] { rect[2], rect[1] });
        }

        if (rect[3] < maxY) {
          while (!np.isEmpty() && np.peek()[0] == rect[0] && np.peek()[1] <= rect[3]) {
            np.poll();
          }
          np.offer(new int[] { rect[0], rect[3] });
        } else if (!np.isEmpty() && np.peek()[0] == rect[0]) {
          while (!np.isEmpty() && np.peek()[0] == rect[0]) {
            np.poll();
          }
        }
      } else {
        perfect = false;
        break;
      }
    }
    return perfect && np.isEmpty();
  }
}
