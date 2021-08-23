package Blind75;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import Utilities.TreeNode;

public class LC0102BinaryTreeLevelOrderTraversal {

	TreeMap<Integer, List<Integer>> levelMap = new TreeMap<Integer, List<Integer>>();
	List<List<Integer>> levels = new ArrayList<List<Integer>>();

	public void helper(TreeNode node, int level) {
		// start the current level
		if (levels.size() == level)
			levels.add(new ArrayList<Integer>());

		// fulfil the current level
		levels.get(level).add(node.val);

		// process child nodes for the next level
		if (node.left != null)
			helper(node.left, level + 1);
		if (node.right != null)
			helper(node.right, level + 1);
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) return levels;
		helper(root, 0);
		return levels;
	}




	public List<List<Integer>> levelOrderWithTreeMap(TreeNode root) {

		List<List<Integer>> allLevels = new ArrayList<List<Integer>>();
		if (root == null) {
			return allLevels;
		}

		helperWithTreeMap(root, 0);

		for (Integer level : levelMap.keySet()) {
			allLevels.add(levelMap.get(level));
		}


		return allLevels;


	}


	public void helperWithTreeMap(TreeNode root, int level) {

		ArrayList<Integer> levelList = new ArrayList<Integer>();
		if (!levelMap.containsKey(level)) {
			levelList.add(root.val);
			levelMap.put(level, levelList);
		} else {
			levelMap.get(level).add(root.val);
		}

		if (root.left != null) {
			helperWithTreeMap(root.left, level+1);
		}
		if (root.right != null) {
			helperWithTreeMap(root.right, level+1);
		}

	}
}
