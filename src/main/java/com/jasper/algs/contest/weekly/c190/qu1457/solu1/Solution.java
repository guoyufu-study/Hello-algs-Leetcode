package com.jasper.algs.contest.weekly.c190.qu1457.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 1457. 二叉树中的伪回文路径
 * 
 * <p>DFS
 */
class Solution {
	
	int ans = 0;

	public int pseudoPalindromicPaths(TreeNode root) {
		if (root == null)
			return 0;
		int nums = 0;
		dfs(root, nums);
		return ans;
	}

	public void dfs(TreeNode root, int temp) {
		int n = temp ^ (1 << root.val);
		if (root.left == null && root.right == null) {
			if (n == 0 || (n & (n - 1)) == 0) {
				++ans;
			}
			return;
		}
		if (root.left != null) {
			dfs(root.left, n);
		}
		if (root.right != null) {
			dfs(root.right, n);
		}
	}
}