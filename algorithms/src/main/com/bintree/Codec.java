package com.bintree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * For example, you may serialize the following tree
 * 
 * 1 / \ 2 3 / \ 4 5 as "[1,2,3,null,null,4,5]", just the same as how LeetCode
 * OJ serializes a binary tree. You do not necessarily need to follow this
 * format, so please be creative and come up with different approaches yourself.
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
 * 
 * @author nraveend
 *
 */
public class Codec {

  private static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }

  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    Queue<TreeNode> lq = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    lq.offer(root);
    while (!lq.isEmpty()) {
      TreeNode cur = lq.poll();
      if (cur == null) {
        sb.append("N ");
      } else {
        sb.append(cur.val);
        sb.append(" ");
        lq.offer(cur.left);
        lq.offer(cur.right);
      }
    }
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    TreeNode root = null;
    int pos = data.indexOf(' ');
    String val = data.substring(0, pos);
    if (val.equals("N")) {
      return root;
    } else {
      Queue<TreeNode> lq = new LinkedList<>();
      root = new TreeNode(Integer.parseInt(val));
      lq.offer(root);
      while (!lq.isEmpty()) {
        TreeNode cur = lq.poll();
        pos += 1;
        int nextPos = data.indexOf(' ', pos);
        String left = data.substring(pos, nextPos);
        if (left.equals("N")) {
          cur.left = null;
        } else {
          TreeNode leftNode = new TreeNode(Integer.parseInt(left));
          cur.left = leftNode;
          lq.offer(leftNode);
        }

        pos = nextPos + 1;
        nextPos = data.indexOf(' ', pos);
        String right = data.substring(pos, nextPos);
        if (right.equals("N")) {
          cur.right = null;
        } else {
          TreeNode rightNode = new TreeNode(Integer.parseInt(right));
          cur.right = rightNode;
          lq.offer(rightNode);
        }
        pos = nextPos ;
      }
    }
    return root;
  }
}
