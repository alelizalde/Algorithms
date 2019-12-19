package com.practices.trees;

import java.util.LinkedList;

public class BinarySearchTreeV3 {

    static class Node {
        public Node left;
        public Node right;
        int val;
        public Node(int val){
            this.val = val;
        }
    }

    static class NodeBounds {
        int lowerBound;
        int upperBound;
        int val;
        Node node;

        NodeBounds(int lowerBound, int upperBound, Node node) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            this.val = node.val;
            this.node = node;
        }
    }

    public static boolean isBinaryTree(Node root){
        LinkedList<NodeBounds> nodeBounds = new LinkedList<>();
        nodeBounds.add(new NodeBounds(Integer.MIN_VALUE, Integer.MAX_VALUE, root));
        while (!nodeBounds.isEmpty()) {
            NodeBounds cur = nodeBounds.pollLast();
            if (cur.val <= cur.lowerBound || cur.val >= cur.upperBound) {
                return false;
            }

            if (cur.node.left != null) {
                nodeBounds.add(new NodeBounds(cur.lowerBound, cur.val, cur.node.left));
            }

            if (cur.node.right != null) {
                nodeBounds.add(new NodeBounds(cur.val, cur.upperBound, cur.node.right));
            }
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

        System.out.println(isBinaryTree(root));
    }
}
