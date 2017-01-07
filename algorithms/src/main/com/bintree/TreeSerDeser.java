package com.bintree;

import java.util.LinkedList;
import java.util.Queue;


public class TreeSerDeser {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
          this.val = val;
        }

      }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> bfsQ = new LinkedList<>();
        bfsQ.offer(root);
        
        while (!bfsQ.isEmpty()) {
            TreeNode cur = bfsQ.poll();
            if (cur == null) {
                sb.append("N");
            } else {
                sb.append(cur.val);
                bfsQ.offer(cur.left);
                bfsQ.offer(cur.right);
            }
            sb.append(':');
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode head = null;
        int pos = data.indexOf(':');
        int prevPos = 0;
        Queue<TreeNode> bfsQ = new LinkedList<>();
        TreeNode parent = null;
        
        while(pos != -1) {
            String curVal = data.substring(prevPos, pos);
            TreeNode cur = null;
            if (!curVal.equals("N")) {
                cur = new TreeNode(Integer.parseInt(curVal));
                bfsQ.offer(cur);
            }
            if (head == null) {
                head = cur;
            } else if (parent == null) {
                parent = bfsQ.poll();
                parent.left = cur;
            } else {
                parent.right = cur;
                parent = null;
            }
            prevPos = pos +1;
            pos = data.indexOf(':',prevPos);
        }
        
        return head;
    }
}
