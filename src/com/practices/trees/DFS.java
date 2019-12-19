package com.practices.trees;

import java.util.LinkedList;

public class DFS {
    static class Node {
        Character val;
        Node left;
        Node right;
        Node(Character val) {
            this.val = val;
        }
    }

    static private void PreOrderStack(Node root){
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node current = stack.pollLast();
            System.out.println(current.val);
            if(current.right!=null) stack.add(current.right);
            if(current.left!=null) stack.add(current.left);
        }

    }

    static private void InOrderStack(Node root){
        LinkedList<Node> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            if(root != null) {
                stack.add(root);
                root = root.left;
            } else {
                root = stack.pollLast();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }

    static private void PostOrderStack(Node root){
        LinkedList<Node> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.offer(root);
                root = root.left;
            }
            Node rightNode = stack.peekLast().right;
            if (rightNode == null) {
                rightNode = stack.pollLast();
                System.out.println(rightNode.val);
                while (!stack.isEmpty() && rightNode == stack.peekLast().right) {
                    rightNode = stack.pollLast();
                    System.out.println(rightNode.val);
                }
            } else {
                root = rightNode;
            }
        }
    }
    // Visit the node, then left sub-tree and then right sub-tree
    static public void traversePreOrder(Node root) {
        System.out.println( root.val );
        if( root.left != null )  traversePreOrder(root.left);
        if( root.right != null )  traversePreOrder(root.right);
    }

    // Visit left sub-tree, then node and then, right sub-tree
    static public void traverseInOrder(Node root) {
        if( root.left != null )traverseInOrder(root.left);
        System.out.println( root.val );
        if( root.right != null ) traverseInOrder(root.right);
    }
    // Visit left sub-tree, then right sub-tree and then the node
    static public void traversePostOrder(Node root) {
        if( root.left != null ) traversePostOrder(root.left);
        if( root.right != null ) traversePostOrder(root.right);
        System.out.println( root.val );
    }

    public static void main(String[] args) {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        Node i = new Node('I');
        f.left = b;
        f.right = g;
        b.left = a;
        b.right = d;
        d.left = c;
        d.right = e;
        g.right = i;
        i.left = h;

        PreOrderStack(f);
        System.out.println("----------");
        InOrderStack(f);
        System.out.println("----------");
        PostOrderStack(f);
        System.out.println("Recursion");
        traversePreOrder(f);
        System.out.println("----------");
        traverseInOrder(f);
        System.out.println("----------");
        traversePostOrder(f);
    }
}
