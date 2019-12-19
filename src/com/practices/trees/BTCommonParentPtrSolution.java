package com.practices.trees;
// Java implementation to find lowest common ancestor of
// n1 and n2 using one traversal of binary tree
// It also handles cases even when n1 and n2 are not there in Tree

/* Class containing left and right child of current Nodev2 and key */

public class BTCommonParentPtrSolution
{
	// Root of the Binary Tree
	Nodev2 root;
	static boolean v1 = false, v2 = false;

	// This function returns pointer to LCA of two given
	// values n1 and n2.
	// v1 is set as true by this function if n1 is found
	// v2 is set as true by this function if n2 is found
	Nodev2 findLCAUtil(Nodev2 Nodev2, int n1, int n2)
	{
		// Base case
		if (Nodev2 == null)
			return null;

		// If either n1 or n2 matches with root's key, report the presence
		// by setting v1 or v2 as true and return root (Note that if a key
		// is ancestor of other, then the ancestor key becomes LCA)
		if (Nodev2.data == n1)
		{
			v1 = true;
			return Nodev2;
		}
		if (Nodev2.data == n2)
		{
			v2 = true;
			return Nodev2;
		}

		// Look for keys in left and right subtrees
		Nodev2 left_lca = findLCAUtil(Nodev2.left, n1, n2);
		Nodev2 right_lca = findLCAUtil(Nodev2.right, n1, n2);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this Nodev2 is the LCA
		if (left_lca != null && right_lca != null)
			return Nodev2;

		// Otherwise check if left subtree or right subtree is LCA
		return (left_lca != null) ? left_lca : right_lca;
	}

	// Finds lca of n1 and n2 under the subtree rooted with 'Nodev2'
	Nodev2 findLCA(int n1, int n2)
	{
		// Initialize n1 and n2 as not visited
		v1 = false;
		v2 = false;

		// Find lca of n1 and n2 using the technique discussed above
		Nodev2 lca = findLCAUtil(root, n1, n2);

		// Return LCA only if both n1 and n2 are present in tree
		if (v1 && v2)
			return lca;

		// Else return NULL
		return null;
	}

	/* Driver program to test above functions */
	public static void main(String args[])
	{
		BTCommonParentPtrSolution tree = new BTCommonParentPtrSolution();
		tree.root = new Nodev2(1);
		tree.root.left = new Nodev2(2);
		tree.root.right = new Nodev2(3);
		tree.root.left.left = new Nodev2(4);
		tree.root.left.right = new Nodev2(5);
		tree.root.right.left = new Nodev2(6);
		tree.root.right.right = new Nodev2(7);

		Nodev2 lca = tree.findLCA(4, 5);
		if (lca != null)
			System.out.println("LCA(4, 5) = " + lca.data);
		else
			System.out.println("Keys are not present");

		lca = tree.findLCA(4, 10);
		if (lca != null)
			System.out.println("LCA(4, 10) = " + lca.data);
		else
			System.out.println("Keys are not present");
	}
}
