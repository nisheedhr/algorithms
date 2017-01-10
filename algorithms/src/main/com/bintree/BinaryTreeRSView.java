package com.bintree;

import java.util.ArrayList;
import java.util.List;


/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can
 *  see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 * @author nisheedh
 *
 */
public class BinaryTreeRSView {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val;}
    };
    
    /**
     * Use BFS(level order) traversal of tree and add rightmost element in 
     * each level to the output list.
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> out= new ArrayList<>();
        if (root != null) {
            List<TreeNode> curLevel = new ArrayList<>();
            curLevel.add(root);
            
            while (!curLevel.isEmpty()) {
                out.add(curLevel.get(curLevel.size() -1).val);
                
                List<TreeNode> nextLevel = new ArrayList<>();
                
                for (int i = 0; i < curLevel.size() ; ++i) {
                    TreeNode cur = curLevel.get(i);
                    if (cur.left != null) {
                        nextLevel.add(cur.left);
                    }
                    
                    if (cur.right != null) {
                        nextLevel.add(cur.right);
                    }
                }
                curLevel = nextLevel;
            }
        }
        return out;
    }
    
}
