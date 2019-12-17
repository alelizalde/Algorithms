package com.practices;

import java.util.LinkedList;

public class BinarySearchTreeRecursion {

    static class Node {
        public Node left;
        public Node right;
        int val;
        public Node(int val){
            this.val = val;
        }
    }

    public static boolean isBinaryTree(Node node, int lowerBound, int upperBound){

        if (node.val <= lowerBound || node.val >= upperBound) {
            return false;
        }

        if (node.left != null) {
           if(!isBinaryTree(node.left, lowerBound, node.val))
               return false;
        }

        if (node.right != null) {
            if(!isBinaryTree(node.right, node.val, upperBound))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        root.left = n2; root.right = n6;
        n2.left = n1; n2.right = n3;
        n6.left = n5; n6.right = n7;

        System.out.println(isBinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
