package com.jasper.algs.leetcode.tree.qu0314.solu1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0314. 二叉树的垂直遍历
 * 
 * <p> BFS 层序遍历
 */
class Solution {
	@SuppressWarnings("serial")
	public List<List<Integer>> verticalOrder(TreeNode root) {

		List<List<Integer>> ans = new LinkedList<>();
		// 层序遍历
		Deque<TreeNode> queue = new LinkedList<>();
		if(root!=null) queue.offer(root);
		Deque<Integer> indexs = new LinkedList<>();
		if (root!=null) indexs.offer(0);
		
		while (!queue.isEmpty()) {
			int len = queue.size();
			int delt = indexs.peek() < 0 ? -indexs.peek() : 0; // 修正
			for (int i = 0; i < len; i++) {
				TreeNode node = queue.poll();
				int index = indexs.poll() + delt;
				if (node.left != null) {
					indexs.offer(index - 1);
					queue.offer(node.left);
				}

				if (node.right != null) {
					indexs.offer(index + 1);
					queue.offer(node.right);
				}

				// 构造答案
				if (index == 0 && delt == 1) { // 新增左节点列
					ans.add(0, new ArrayList<Integer>() {
						{
							add(node.val);
						}
					});
				} else {
					if (index == ans.size()) { // 新增右节点列
						ans.add(new ArrayList<>());
					}
					List<Integer> tmp = ans.get(index);
					tmp.add(node.val);
				}

			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// [[15, 7], [9, 20], [3]]
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		System.out.println(new Solution().verticalOrder(root));
	}
}