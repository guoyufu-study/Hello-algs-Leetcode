package com.jasper.algs.leetcode.tree.qu0110.solu2;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0110. 平衡二叉树
 * 
 * <p> DFS 后序遍历 （自底向上）
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
    	
    	return deep(root) > -1;
    }

	int deep(TreeNode node) {
		
		if(node==null) return 0; // 平衡
		
		int left = deep(node.left);
		if(left==-1) return left; // 不平衡
		
		int right = deep(node.right);
		if(right==-1) return right; // 不平衡
		
		if(Math.abs(left-right)>1) return -1; // 不平衡
		
		return Math.max(left, right) + 1; // 平衡
	}
}