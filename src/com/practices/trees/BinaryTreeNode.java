package com.practices.trees;

public class BinaryTreeNode {

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

	public void addNode(int num) {
		if (num < this.value) {
			if (this.left != null) {
				this.left.addNode(num);
			} else {
				this.left = new BinaryTreeNode(num);
			}

		} else {
			if (this.right != null) {
				this.right.addNode(num);
			} else {
				this.right = new BinaryTreeNode(num);
			}

		}
	}
}
