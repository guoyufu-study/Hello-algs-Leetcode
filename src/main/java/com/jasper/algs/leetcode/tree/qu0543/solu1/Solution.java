package com.jasper.algs.leetcode.tree.qu0543.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0543. 二叉树的直径
 * 
 * <p> DFS 后序遍历
 */
class Solution {
	int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
    	dfs(root);
    	return ans;
    }
	
    /**
     * 返回树的深度
     */
    int dfs(TreeNode root) {
    	if(root==null) return 0;
    	
    	int L = dfs(root.left);
    	int R = dfs(root.right);
    	
    	ans = Math.max(ans, L+R);
    	
    	return Math.max(L, R) + 1;
    	
	}
}