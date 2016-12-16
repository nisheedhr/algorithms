package com.topdown;

import java.util.PriorityQueue;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 *  compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Show Company Tags
Show Tags
Show Similar Problems

 * @author nraveend
 *
 */
public class TrappingRainWater {

  /** use 2 pointer technique
   * left and right pointing to max on each side.
   * Move in direction of the max among both
   * @param height
   * @return
   */
  public int trapOptimal(int[] height) {
    int area = 0;
    int left = 0;
    int right = height.length - 1;
    int leftMax = 0;
    int rightMax = 0;
    
    while (left < right) {
      leftMax = Math.max(leftMax, height[left]);
      rightMax = Math.max(rightMax, height[right]);
      
      if (leftMax < rightMax) {
        area += leftMax -height[left];
        left++;
      } else {
        area += rightMax - height[right];
        right--;
      }
    }
    return area;
  }
  private static class Wall {
    int low;
    int high;
    int pos;
    WallType type;
    
    Wall(int low, int high, int pos) {
      this.low = low;
      this.high = high;
      this.pos = pos;
    }
  }
  
  enum WallType {
    LEFT, RIGHT
  }
  /**
   * Key idea is to use to a priority queue for elevation(walls).
   * On encountering higher wall compute the area by popping all lower ones. Don't push higher wall
   * On encountering lower wall compute the area with the current highest. No popping.
   * Push the lower wall.
   * On encountering same height or zero size, continue
   * @param height
   * @return
   */
  public int trap(int[] height) {
    int totalArea = 0;
    PriorityQueue<Wall> pq = new PriorityQueue<>((first, second) -> first.high - second.high);
    int prev = 0; // For previous height.
    for (int i = 0; i < height.length; ++i) {
      if (i== 0 || prev == height[i]) {
        prev = height[i];
        continue;
      }
      
      Wall wl = new Wall(Math.min(prev, height[i]), Math.max(prev, height[i]), i);
      if (prev < height[i]) {
        wl.type = WallType.RIGHT;
      } else  {
        wl.type = WallType.LEFT;
      } 
      
      if (wl.type == WallType.LEFT) {
        pq.offer(wl);
      } else if (wl.type == WallType.RIGHT && !pq.isEmpty()) {
        if (wl.high >= pq.peek().high) {
          while (!pq.isEmpty() && wl.high >= pq.peek().high) {
            Wall left = pq.poll();
            totalArea += (i - left.pos) * (left.high - Math.max(left.low, wl.low));
            wl.low = Math.max(left.high, wl.low);
          }
        }
        
        if (!pq.isEmpty() && wl.high < pq.peek().high) {
          totalArea += (i - pq.peek().pos) * (wl.high - Math.max(pq.peek().low, wl.low));
        }
      }
      prev = height[i];
    }
    return totalArea;
  }
}
