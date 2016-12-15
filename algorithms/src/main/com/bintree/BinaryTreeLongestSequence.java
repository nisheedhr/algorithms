package com.bintree;

/**Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 * 
 */
public class BinaryTreeLongestSequence {

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val) { this.val = val;}
	};
	
	/**
	 * Post-Order traversal of the tree.
	 * Keep track of current length and increment it if cur val = prev val +1 .
	 * maxlen = Math.max(left, right, max);
	 * @param root
	 * @return
	 */
	public int longestConsecutive(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int maxLen = 0;
		int curLen = 1;
		int prev = root.val;
		int leftLen = maxSeq(root.left, prev, curLen, maxLen);
		int rightLen = maxSeq(root.right, prev, curLen, maxLen);
		return Math.max(leftLen, rightLen);
	}

	private int maxSeq(TreeNode node, int prev, int curLen, int maxLen) {
		if(node == null) {
			return curLen;
		}
		
		if(node.val == prev + 1) {
			curLen ++;
			if(curLen > maxLen) {
				maxLen = curLen;
			}
		}
		else {
			curLen = 1;
		}
		int leftLen = maxSeq(node.left, node.val, curLen, maxLen);
		int rightLen = maxSeq(node.right, node.val, curLen, maxLen);
		return Math.max(Math.max(leftLen, rightLen), maxLen);
		
	}
}
