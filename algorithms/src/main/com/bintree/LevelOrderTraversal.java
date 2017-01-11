package com.bintree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LevelOrderTraversal {


    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
          this.val = val;
        }

      };
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> bfsQ = new LinkedList<>();
            bfsQ.offer(root);
            while (!bfsQ.isEmpty()) {
                List<Integer> ll = new ArrayList<>();
                Queue<TreeNode> nl = new LinkedList<>();
                out.add(ll);
                while (!bfsQ.isEmpty()) {
                    TreeNode cur = bfsQ.poll();
                    ll.add(cur.val);
                    if (cur.left != null) {
                        nl.offer(cur.left);
                    }
                    
                    if (cur.right != null) {
                        nl.offer(cur.right);
                    }
                }
                
                if (!nl.isEmpty()) {
                    bfsQ = nl;
                }
            }
        }
        return out;
    }
}
