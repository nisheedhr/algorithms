package com.bintree;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
 * @author nisheedh
 *
 */
public class ValidBST {


    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
          this.val = val;
        }

      }
    /**
     * The key trick is to use minNode and maxNode instead of
     * Integer.MIN_VALUE and Integer.MAX_VALUE for range comparison
     * in recursive function call
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        TreeNode minNode = null;
        TreeNode maxNode = null;
        return isValidBST(root, minNode, maxNode);
    }

    private boolean isValidBST(TreeNode node, TreeNode minNode, TreeNode maxNode) {  
        if (node == null) {
            return true;
            // Checks the nodes on left subtree
        } else if ((minNode == null || node.val > minNode.val) && 
                   // Checks the nodes on right sub tree
                (maxNode == null || node.val < maxNode.val)) {
            // for left subtree minNode is always null. Max node will be parent
            return isValidBST(node.left, minNode, node) &&
                // for right sub tree max node will be null. Min node will be parent.
                isValidBST(node.right, node, maxNode);
        } else {
            return false;
        }
    }
}
