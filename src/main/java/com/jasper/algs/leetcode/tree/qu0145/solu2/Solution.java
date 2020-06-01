package com.jasper.algs.leetcode.tree.qu0145.solu2;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0145. 二叉树的后序遍历
 * 
 * <p>
 * 迭代实现
 */
class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {

		Stack<TreeNode> helper = new Stack<>();
		LinkedList<Integer> ans = new LinkedList<>();

		// 边界
		if (root == null)
			return ans;

		helper.add(root);
		while (!helper.isEmpty()) {
			
			// 中节点：前插构造答案
			TreeNode node = helper.pop();
			ans.addFirst(node.val);
			
			// 左子节点
			if (node.left != null)
				helper.add(node.left);

			// 右子节点
			if (node.right != null)
				helper.add(node.right);
		}
		return ans;
	}

}