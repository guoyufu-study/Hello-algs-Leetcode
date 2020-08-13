package com.jasper.algs.contest.weekly.c120.qu0979.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0979. 在二叉树中分配硬币
 * 
 * <p> DFS
 */
class Solution {
    
	private int ans;
	
	public int distributeCoins(TreeNode root) {
		
    	dfs(root);
    	
    	return ans;
    }

	private int dfs(TreeNode node) {
		if(node==null)
			return 0;
		
		// 叶子节点 过载量
		int L = dfs(node.left);
		int R = dfs(node.right);
		ans += Math.abs(L) + Math.abs(R);
		
		// 父节点 变成  叶子节点
		return node.val + L + R - 1;
	}
}