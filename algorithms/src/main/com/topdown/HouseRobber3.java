package com.topdown;

/**
 * The thief has found himself a new place for his theft again. 
 * There is only one entrance to this area, called the "root."
 *  Besides the root, each house has one and only one parent house.
 *   After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
 *   It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *   

Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * @author nraveend
 *
 */
public class HouseRobber3 {

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode (int x) { val = x; }
  }
  
  private static class Result {
    int prev;
    int prevPrev;
  }
  /**
   * Extend the idea of house robber 1
   * Do postOrder traversal of tree with prev and prevPrev as auxiliary nodes.
   * res.prev = Math.max(node.val + res.prevPrev + lPrevPrev, rPrev + lPrev);
    res.prevPrev = lPrev + rPrev;
   * @param root
   * @return
   */
  public int rob(TreeNode root) {
    Result res = new Result();
    postOrderRob(root, res);
    return res.prev;
  }
  
  private void postOrderRob(TreeNode node, Result res) {
    if (node == null) {
      res.prev = 0;
      res.prevPrev = 0;
      return;
    }
    
    postOrderRob(node.left, res);
    
    int lPrev = res.prev;
    int lPrevPrev = res.prevPrev;
    
    postOrderRob(node.right, res);
    
    int rPrev = res.prev;
    res.prev = Math.max(node.val + res.prevPrev + lPrevPrev, rPrev + lPrev);
    res.prevPrev = lPrev + rPrev;
  }

}
