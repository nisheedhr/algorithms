package com.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
 * @author nisheedh
 *
 */
public class SlidingWindowMax {

    /**
     * Use a Dequeue. Store the index of max elements in dequeue
     * While sliding window, remove all elements which are lower than current one as they can't be max.
     * Remove index from dequeue which is outside the boundary.
     * Maximum element is always at front. All elements less than that are removed.
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return new int[]{};
        }
        int out[] = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        
        for (int i = 0 ; i < k; ++i) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }

        int j = 0;
        for (int i = k; i < nums.length ; ++i, ++j) {
            out[j] = nums[dq.peekFirst()];
            
            // Remove all smaller indexes
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.removeLast();
            }
            
            // Remove all elements outside boundary
            while (!dq.isEmpty() && dq.peekFirst() <= i -k) {
                dq.removeFirst();
            }
            dq.addLast(i);
        }
        out[j] = nums[dq.peekFirst()];
        return out;
    }
}
