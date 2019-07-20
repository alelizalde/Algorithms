package com.practices;

import java.util.*;

public class DelNodes {

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<Integer> toDelete = new ArrayList<>();
        for( int i=0; i< to_delete.length; i++) {
            toDelete.add(to_delete[i]);
        }
        List<TreeNode> ans = new ArrayList<>();

        TreeNode node = dfs (root, toDelete, ans);

        if (node != null) ans.add(node);

        return ans;
    }

    private static TreeNode dfs (TreeNode node, List<Integer> toDelete, List<TreeNode> ans) {
        if (node == null) return null;

        node.left = dfs (node.left, toDelete, ans);
        node.right = dfs (node.right, toDelete, ans);

        if( toDelete.contains(node.val)) {
            if(node.left != null) ans.add(node.left);
            if(node.right != null) ans.add(node.right);
            return null;
        }

        return node;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        delNodes(t1, new int[]{2, 5});
    }
}
