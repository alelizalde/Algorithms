package com.practices;

import java.util.LinkedList;

public class TreeTraversals {

    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+ " ");
        inOrder(root.right);
    }

    private void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+ " ");
    }

    private void inorderItr(TreeNode node){
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.offer(node);
                node = node.left;
            }
            node = stack.pollLast();
            System.out.println(node.val);
            node = node.right;
        }
    }

    private void preOrderItr(TreeNode node){
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.addFirst(node);
        while(!stack.isEmpty()){
            node = stack.pollLast();
            System.out.print(node.val+ " ");
            if(node.right != null) stack.offer(node.right);
            if(node.left!= null) stack.offer(node.left);
        }
    }

    private void postOrderItr(TreeNode root){
        LinkedList<TreeNode> stack1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> stack2 = new LinkedList<TreeNode>();
        stack1.offer(root);
        while(!stack1.isEmpty()){
            root = stack1.pollLast();
            if(root.left != null) stack1.offer(root.left);
            if(root.right != null) stack1.offer(root.right);
            stack2.offer(root);
        }

        while(!stack2.isEmpty())
            System.out.print(stack2.pollLast().val + " ");
    }

    private void postOrderItrOneStack(TreeNode root){
        TreeNode current = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(current != null || !stack.isEmpty()){
            while(current != null) {
                stack.offer(current);
                current = current.left;
            }
            TreeNode temp = stack.peekLast().right;
            if (temp == null) {
                temp = stack.pollLast();
                System.out.print(temp.val + " ");
                while (!stack.isEmpty() && temp == stack.peekLast().right) {
                    temp = stack.pollLast();
                    System.out.print(temp.val + " ");
                }
            } else {
                current = temp;
            }
        }
    }

    public static void main(String args[]){
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


        TreeTraversals tt = new TreeTraversals();
        tt.postOrder(root);
        System.out.println();
        tt.postOrderItr(root);
        System.out.println();
        tt.postOrderItrOneStack(root);
    }
}