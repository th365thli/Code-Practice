package Blind75;

import java.util.HashMap;
import java.util.Map;

import Utilities.TreeNode;

public class LC0105ConstructBinaryTreeFromPreandInorder {


	private static int preorderIndex;
	private static Map<Integer, Integer> inorderIndexMap;
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		preorderIndex = 0;
		// build a hashmap to store value -> its index relations
		inorderIndexMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inorderIndexMap.put(inorder[i], i);
		}

		return arrayToTree(preorder, 0, preorder.length - 1);
	}

	private static TreeNode arrayToTree(int[] preorder, int left, int right) {
		// if there are no elements to construct the tree
		if (left > right) return null;

		// select the preorder_index element as the root and increment it
		int rootValue = preorder[preorderIndex++];
		TreeNode root = new TreeNode(rootValue);

		// build left and right subtree
		// excluding inorderIndexMap[rootValue] element because it's the root
		root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
		root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
		return root;
	}

	public static void main(String[] args) {

		int[] preorder = {1,2}; int[] inorder = {1,2};

		TreeNode node = buildTree(preorder, inorder);
		System.out.println(node);

	}


}
