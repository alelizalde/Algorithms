package com.practices;

import java.util.*;

import static java.lang.System.out;

public class LcaDeepestLeaves {

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs (root, 0).firstEntry().getValue();
    }

    private static TreeMap<Integer, TreeNode> dfs (TreeNode node, Integer depth) {

        if (node.left == null && node.right == null) {
            TreeMap<Integer, TreeNode>  nn = new TreeMap<>();
            nn.put(depth, node);
            return nn;
        } else if (node.left == null)
            return dfs(node.right, depth + 1);
        else if (node.right == null)
            return dfs(node.left, depth + 1);
        else {
            TreeMap<Integer, TreeNode>  nodeA = dfs(node.left, depth + 1);
            TreeMap<Integer, TreeNode>  nodeB = dfs(node.right, depth + 1);
            if (nodeA.firstKey() > nodeB.firstKey()) return nodeA;
            if (nodeB.firstKey() > nodeA.firstKey()) return nodeB;
            TreeMap<Integer, TreeNode>  nn = new TreeMap<>();
            nn.put(nodeA.firstKey(), node);
            return nn;
        }

    }


    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t4.right = t5;
        out.println(lcaDeepestLeaves(t1).val);
    }
}

