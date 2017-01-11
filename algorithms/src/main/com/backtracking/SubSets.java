package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * @author nisheedh
 *
 */
public class SubSets {

    /**
     * Build the solution recursively from previous list
     * Create copy of the list whenever new element is added to it.
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        if (nums != null && nums.length > 0) {
            List<Integer>curList = new ArrayList<>();
            out.add(curList);
            int pos = 0;
            genAllCombinations(nums, curList, out, pos);
        }
        return out;
    }

    private void genAllCombinations(int[] nums, List<Integer> curList, List<List<Integer>> out, int pos) {
        if (nums.length == curList.size() || pos == nums.length) {
            return;
        }
        
        for (int i = pos; i < nums.length ; ++i) {
            curList.add(nums[i]);
            out.add(new ArrayList<>(curList));
            genAllCombinations(nums, curList, out, i + 1);
            curList.remove(curList.size() -1);
        }
    }
}
