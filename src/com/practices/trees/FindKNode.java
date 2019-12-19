package com.practices.trees;

public class FindKNode {
    static class Node {
        Node left;
        Node right;
        int num_children;
        int position;
        Node (int num_children, int position) {
            this.num_children = num_children;
            this.position = position;
        }
    }

   static  public Node find (Node node, int k) {
        if (node == null) return null;
        int position;
        if (node.left != null)
            position = node.left.num_children + 1 + 1;
        else
            position = 1;
        if (position == k) return node;
        if (position > k)
            return find(node.left, k);
        else
            return find(node.right, k - position);
    }

    /*
              o
           /    \
          o      o
         / \    / \
        o   o  o   o
       /      /
      o      o
    */

    public static void main(String[] args) {
        Node n1 = new Node(0, 1);
        Node n2 = new Node(1, 2);
        Node n3 = new Node(3, 3);
        Node n4 = new Node(0, 4);
        Node n5 = new Node(8, 5);
        Node n6 = new Node(0, 6);
        Node n7 = new Node(1, 7);
        Node n8 = new Node(3, 8);
        Node n9 = new Node(0, 9);
        n5.left=n3;n5.right=n8;
        n3.left=n2;n3.right=n4;
        n2.left=n1;
        n8.left=n7;n8.right=n9;
        n7.left=n6;

        System.out.println(find(n5, 4).position);
        System.out.println(find(n5, 1).position);
        System.out.println(find(n5, 8).position);
        System.out.println(find(n5, 18));
    }
}
