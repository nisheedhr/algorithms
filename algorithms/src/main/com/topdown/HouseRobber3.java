package com.topdown;

/**
 * The thief has found himself a new place for his thievery again. 
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
    int k1;
    int k2;
  }
  /**
   * Extend the idea of house robber 1
   * Do postOrder traversal of tree with kMinus1 and kMinus2 as auxiliary nodes.
   * @param root
   * @return
   */
  public int rob(TreeNode root) {
    Result res = new Result();
    postOrderRob(root, res);
    return Math.max(res.k1, res.k2);
  }
  
  private void postOrderRob(TreeNode node, Result res) {
    if (node == null) {
      res.k1 = 0;
      res.k2 = 0;
      return;
    }
    
    postOrderRob(node.left, res);
    
    int lk1 = res.k1;
    int lk2 = res.k2;
    
    postOrderRob(node.right, res);
    
    int rk1 = res.k1;
    res.k1 = Math.max(node.val + res.k2 + lk2, res.k1 + lk1);
    res.k2 = lk1 + rk1;
  }

}
