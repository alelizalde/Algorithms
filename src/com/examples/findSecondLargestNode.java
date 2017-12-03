package com.examples;

public class findSecondLargestNode {
	private static int findLargest(BinaryTreeNode rootNode) {
		BinaryTreeNode current = rootNode;
		while (current.right != null) {
			current = current.right;
		}
		return current.value;
	}

	public static int findSecondLargest(BinaryTreeNode rootNode) {
		if (rootNode == null || (rootNode.left == null
				&& rootNode.right == null)) {
			throw new IllegalArgumentException("Tree must have at least 2 nodes");
		}

		BinaryTreeNode current = rootNode;

		while (true) {

			// case: current is largest and has a left subtree
			// 2nd largest is the largest in that subtree
			if (current.left != null && current.right == null) {
				return findLargest(current.left);
			}
			
			System.out.println(current.value);

			// case: current is parent of largest, and largest has no children,
			// so current is 2nd largest
			if (current.right != null &&
					current.right.left == null &&
					current.right.right == null) {
				return current.value;
			}

			current = current.right;
		}
	}

	public static void main(String args[]) {
		BinaryTreeNode tree = new BinaryTreeNode(10);
		tree.insertLeft(2).insertRight(3).insertLeft(4).insertRight(5);
		tree.insertRight(6).insertLeft(7).insertRight(8).insertLeft(9);
		System.out.println(findSecondLargest(tree));
	}

}
