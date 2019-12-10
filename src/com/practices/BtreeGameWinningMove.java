package com.practices;

import java.util.*;

public class BtreeGameWinningMove {
    static public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        LinkedList<TreeNode> stack = new LinkedList<>(),
                right = new LinkedList<>(),
                left = new LinkedList<>(),
                childStack = new LinkedList<>();
        int lcounter = 0, rcounter = 0;

        childStack.offer(root);
        while (!childStack.isEmpty()) {
            root = childStack.pollLast();
            if (root.left != null) childStack.offer(root.left);
            if (root.right != null) childStack.offer(root.right);
            stack.offer(root);
        }

        while (!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            if (node.val == x) {
                TreeNode lnode = node;
                if (lnode.left != null) left.offer(lnode.left);
                while (!left.isEmpty()) {
                    lnode = left.pollLast();
                    lcounter++;
                    if (lnode.left != null) left.offer(lnode.left);
                    if (lnode.right != null) left.offer(lnode.right);
                }

                TreeNode rnode = node;
                if (rnode.right != null) right.offer(rnode.right);
                while (!right.isEmpty()) {
                    rnode = right.pollLast();
                    rcounter++;
                    if (rnode.left != null) right.offer(rnode.left);
                    if (rnode.right != null) right.offer(rnode.right);
                }
            }
        }
        int[] list = new int[1];
        int[] snapList = new int[list.length];
        System.arraycopy(list, 0, snapList, 0, list.length);
        //System.out.println("lcounter="+lcounter+", rcounter="+rcounter);
        return Math.max(Math.max(lcounter, rcounter), n - lcounter - rcounter - 1) > n / 2;
    }

    static int left, right, val;
    static public boolean btreeGameWinningMoveRec(TreeNode root, int n, int x) {
        val = x;
        count(root);
        //System.out.println("left="+left+", right="+right);
        return Math.max(Math.max(left, right), n - left - right - 1) > n / 2;
    }

    static private int count(TreeNode node) {
        if (node == null) return 0;
        int l = count(node.left), r = count(node.right);
        if (node.val == val) {
            left = l;
            right = r;
        }
        return l + r + 1;
    }

    public static void main(String[] args) {
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
        System.out.println(btreeGameWinningMove(root, 11,2));
        System.out.println(btreeGameWinningMoveRec(root, 11,2));
    }
}
