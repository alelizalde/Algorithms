package com.practices;

import java.util.Stack;

public class findSecondLargestValue {

	static int[] values = {Integer.MIN_VALUE,Integer.MIN_VALUE};
	
	public static int FindSecondValue(BinaryTreeNode root) {
	
		Stack<BinaryTreeNode> stack =new Stack<BinaryTreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			BinaryTreeNode node =  stack.pop();
			
			if(node.value > values[0]) {
				values[1]=values[0];
				values[0]=node.value;
			}
			
			if(node.value < values[0] && node.value>values[1]) {
				values[1]=node.value;
			}
			
			if(node.left!=null) {
				stack.push(node.left);
			}
			
			if(node.right!=null) {
				stack.push(node.right);
			}
			
		}
		return values[1];
	}
	
	
	public static void main(String args[]) {
		BinaryTreeNode tree = new BinaryTreeNode(10);
		tree.insertLeft(2).insertRight(3).insertLeft(4).insertRight(5);
		tree.insertRight(6).insertLeft(7).insertRight(8).insertLeft(9);
		System.out.println(FindSecondValue(tree));
	}
}
