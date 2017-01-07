package com.bintree;

import org.junit.Test;

import com.bintree.TreeSerDeser.TreeNode;

public class TreeSerDeserTest {

    @Test
    public void testSerialize() throws Exception {
       TreeNode root = new TreeNode(2);
       TreeNode left = new TreeNode(1);
       TreeNode right = new TreeNode(3);
       root.left = left;
       root.right = right;
       String data =new TreeSerDeser().serialize(root);
       new TreeSerDeser().deserialize(data);
    }

}
