package com.practices;

import java.util.*;

public class TreePostOrder {
    private static void postorder(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.offer(node);
                node = node.left;
            }
            TreeNode rightNode = stack.peekLast().right;
            if (rightNode == null) {
                rightNode = stack.pollLast();
                System.out.println(rightNode.val);
                while (!stack.isEmpty() && rightNode == stack.peekLast().right) {
                    rightNode = stack.pollLast();
                    System.out.println(rightNode.val);
                }
            } else {
                node = rightNode;
            }
        }
    }

    public static void main(String[] args) {
        /*******************
                         1
                     /       \
                   /          \
                 2             3
             /      \        /   \
            4        5      6    7
          /  \     /  \
         8   9    10  11
         ******************/
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        postorder(root);
    }

}
