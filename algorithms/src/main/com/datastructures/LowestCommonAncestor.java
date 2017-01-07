package com.datastructures;

public class LowestCommonAncestor {

    private static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;
    }
    
    /**
     * Find the lowest common ancestor of two given nodes
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        } else if ((p.val <= root.val && q.val >= root.val) || (p.val >= root.val && q.val <= root.val)) {
            return root;
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
    
}
