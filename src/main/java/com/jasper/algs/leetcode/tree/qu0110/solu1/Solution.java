package com.jasper.algs.leetcode.tree.qu0110.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0110. 平衡二叉树
 * 
 * <p> DFS 前序遍历 （自顶向下）
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
    	
    	if(root==null) return true;
    	
    	return Math.abs(deep(root.left)-deep(root.right))<=1 
    			&& isBalanced(root.left) 
    			&& isBalanced(root.right);
    }

	int deep(TreeNode node) {
		if(node==null) return 0;
		return Math.max(deep(node.left), deep(node.right)) + 1;
	}
}