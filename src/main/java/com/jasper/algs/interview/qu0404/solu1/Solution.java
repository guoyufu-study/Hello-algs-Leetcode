package com.jasper.algs.interview.qu0404.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 面试题 04.04. 检查平衡性
 * 
 * <p> 递归
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