package com.practices;

import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CreateBinaryTree {

	public static void main(String[] args) {
		BinaryTreeNode tree = new BinaryTreeNode(10);
		//tree.insertLeft(2).insertRight(7);
		//tree.insertRight(6);
		tree.addNode(5);
		tree.addNode(3);
		tree.addNode(7);
		tree.addNode(6);
		tree.addNode(8);
		tree.addNode(15);
		tree.addNode(13);
		tree.addNode(17);
		tree.addNode(16);
		tree.addNode(18);
		tree.left.left.insertLeft(20);
		System.out.println("--------DFS---------");
		TravelTreeDFS(tree);
		System.out.println("--------BFS---------");
		TravelTreeBFS(tree);
		System.out.println("--------Search common Parent---------");
		System.out.println(SearchCommonParent(tree,3,8,5));

	}

	private static void TravelTreeDFS(BinaryTreeNode root) {

		Stack<BinaryTreeNode> stack =new Stack<BinaryTreeNode>();
		stack.push(root);

		while(!stack.isEmpty()) {
			BinaryTreeNode node =  stack.pop();
			System.out.println("value:"+node.value+" size: "+stack.size());

			if(node.left!=null) {
				System.out.println("left:"+node.left.value);
				stack.push(node.left);
			}

			if(node.right!=null) {
				System.out.println("right:"+node.right.value);
				stack.push(node.right);
			}
		}
	}

	private static boolean SearchCommonParent(BinaryTreeNode root,int num1, int num2, int parent) {

		Stack<BinaryTreeNode> stack =new Stack<BinaryTreeNode>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		stack.push(root);

		while(!stack.isEmpty()) {
			BinaryTreeNode node =  stack.pop();
			path.add(node.value);
			System.out.println("value:"+node.value+" size: "+stack.size());

			if(node.value==num1) {
				findParent(path,parent);
			}
			
			if(node.left!=null) {
				System.out.println("left:"+node.left.value);
				stack.push(node.left);
			}

			if(node.right!=null) {
				System.out.println("right:"+node.right.value);
				stack.push(node.right);
			}
			
			if(node.right==null && node.left==null) {
				path.clear();
			}
		}
		return false;
	}

	private static boolean findParent(ArrayList<Integer> path, int parent) {
		
		for(Integer current : path) {
			if(current==parent) {
				return true;
			}
		}
		return false;
		
	}

	private static void TravelTreeBFS(BinaryTreeNode root) {

		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);

		while(!queue.isEmpty()) {

			BinaryTreeNode node =  queue.poll();
			System.out.println("value:"+node.value+" size: "+queue.size());

			if(node.left!=null) {
				System.out.println("left:"+node.left.value);
				queue.add(node.left);
			}

			if(node.right!=null) {
				System.out.println("right:"+node.right.value);
				queue.add(node.right);
			}
		}
	}

}
