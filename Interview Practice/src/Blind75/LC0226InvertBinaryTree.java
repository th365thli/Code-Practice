package Blind75;

import Utilities.TreeNode;

public class LC0226InvertBinaryTree {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */

	public TreeNode invertTree(TreeNode root) {

		if (root == null) {
			return null;
		}

		invert(root);
		return root;

	}


	public void invert(TreeNode root) {

		if (root.left == null && root.right == null) {
			return;
		}
		else if (root.left == null && root.right != null) {
			root.left = root.right;
			root.right = null;
			invert(root.left);
		} 
		else if (root.right == null && root.left != null) {
			root.right = root.left;
			root.left = null;
			invert(root.right);
		}
		else {
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;

			invert(root.left);
			invert(root.right);
		}
	}

}