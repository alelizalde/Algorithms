package com.examples;

import java.util.Stack;


public class BinarySearchTreev2 {

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
	
public static class BTAndBoundies{
	public BinaryTreeNode node;
	public int upperBoundry;
	public int lowerBoundry;
	
	BTAndBoundies(BinaryTreeNode node, int upperBoundry, int lowerBoundry){
		this.node=node;
		this.upperBoundry=upperBoundry;
		this.lowerBoundry=lowerBoundry;
	}
}

public static boolean isBinarySearchTree(BinaryTreeNode root){
	
	Stack<BTAndBoundies> stack = new Stack<BTAndBoundies>();
	stack.push(new BTAndBoundies(root,Integer.MAX_VALUE,Integer.MIN_VALUE));
	
	while(!stack.isEmpty()) {
		BTAndBoundies nodeBoundry = stack.pop();
        System.out.println("node.value: "+nodeBoundry.node.value);
        System.out.println("upperBound: "+nodeBoundry.upperBoundry);
        System.out.println("lowerBound: "+nodeBoundry.lowerBoundry);
		if(nodeBoundry.node.value >=nodeBoundry.upperBoundry || nodeBoundry.node.value<=nodeBoundry.lowerBoundry) {
			return false;
		}
		
		if(nodeBoundry.node.left!=null) {
			stack.push(new BTAndBoundies(nodeBoundry.node.left, nodeBoundry.node.value,nodeBoundry.lowerBoundry));
		}
		
		if(nodeBoundry.node.right!=null) {
			stack.push(new BTAndBoundies(nodeBoundry.node.right,nodeBoundry.upperBoundry ,nodeBoundry.node.value));
		}
		
	}
	
	return true;
}
	public static void main(String[] args) {
		BinaryTreeNode tree = new BinaryTreeNode(9);
		tree.insertLeft(8).insertLeft(5).insertRight(6);
		tree.insertRight(11).insertRight(13).insertLeft(12);
		//tree.insertRight(6).insertLeft(7).insertLeft(8).insertRight(9);

		System.out.println(isBinarySearchTree(tree));

	}

}
