package com.practices;

import javafx.util.Pair;
import static java.lang.System.out;

public class LcaDeepestLeaves {
    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs (root, 0).getKey();
    }

    private static Pair<TreeNode, Integer> dfs (TreeNode node, int depth) {

        if (node.left == null && node.right == null) {
            return new Pair<>(node, depth);
        } else if (node.left == null)
            return dfs(node.right, depth + 1);
        else if (node.right == null)
            return dfs(node.left, depth + 1);
        else {
            Pair<TreeNode, Integer> nodeA = dfs(node.left, depth + 1);
            Pair<TreeNode, Integer> nodeB = dfs(node.right, depth + 1);
            if (nodeA.getValue() > nodeB.getValue()) return nodeA;
            if (nodeB.getValue() > nodeA.getValue()) return nodeB;
            return new Pair<>(node, nodeA.getValue());
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
        t2.right = t5;
        out.println(lcaDeepestLeaves(t1).val);
    }
}

