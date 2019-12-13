package com.practices;

import java.util.Stack;

public class BinarySearchTree {

	public static class BinaryTreeNode {

	    public int value;
	    public BinaryTreeNode left;
	    public BinaryTreeNode right;

	    public BinaryTreeNode(int value) {
	        this.value = value;
	    }

	    public BinaryTreeNode insertLeft(int leftValue) {
	        this.left = new BinaryTreeNode(leftValue);
	        return this.left;
	    }

	    public BinaryTreeNode insertRight(int rightValue) {
	        this.right = new BinaryTreeNode(rightValue);
	        return this.right;
	    }
	}
	
	private static class NodeBounds {

	    BinaryTreeNode node;
	    int lowerBound;
	    int upperBound;

	    NodeBounds(BinaryTreeNode node, int lowerBound, int upperBound) {
	        this.node = node;
	        this.lowerBound = lowerBound;
	        this.upperBound = upperBound;
	    }
	}

	public static boolean isBinarySearchTree(BinaryTreeNode root) {

	    // start at the root, with an arbitrarily low lower bound
	    // and an arbitrarily high upper bound
	    Stack<NodeBounds> nodeAndBoundsStack = new Stack<>();
	    nodeAndBoundsStack.push(new NodeBounds(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

	    // depth-first traversal
	    while (!nodeAndBoundsStack.empty()) {
	        NodeBounds nodeBounds = nodeAndBoundsStack.pop();
	        BinaryTreeNode node = nodeBounds.node;
	        int lowerBound = nodeBounds.lowerBound;
	        int upperBound = nodeBounds.upperBound;
	        System.out.println("node.value: "+node.value);
            System.out.println("upperBound: "+upperBound);
            System.out.println("lowerBound: "+lowerBound);
	        // if this node is invalid, we return false right away
	        if (node.value <= lowerBound || node.value >= upperBound) {
	            return false;
	        }

	        if (node.left != null) {
	            // this node must be less than the current node
	            nodeAndBoundsStack.push(new NodeBounds(node.left, lowerBound, node.value));
	        }
	        if (node.right != null) {
	            // this node must be greater than the current node
	            nodeAndBoundsStack.push(new NodeBounds(node.right, node.value, upperBound));
	        }
	    }

	    // if none of the nodes were invalid, return true
	    // (at this point we have checked all nodes)
	    return true;
	}
	/*
	     9
	    / \
	  8    11
	 /       \
	 5       13
	  \      /
	   6    12
	 */
	public static void main(String[] args) {
		BinaryTreeNode tree = new BinaryTreeNode(9);
		tree.insertLeft(8).insertLeft(5).insertRight(6);
		tree.insertRight(11).insertRight(13).insertLeft(12);
		//tree.insertRight(6).insertLeft(7).insertLeft(8).insertRight(9);

		System.out.println(isBinarySearchTree(tree));

	}

}
