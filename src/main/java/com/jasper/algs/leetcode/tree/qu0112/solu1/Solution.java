package com.jasper.algs.leetcode.tree.qu0112.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0112. 路径总和
 * 
 * <p> DFS 前序遍历
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root==null) return false;
    	
    	sum -= root.val;
    	
    	// 叶子节点
    	if(root.left==null && root.right == null) return sum == 0;
    	
    	// 非叶子节点
    	return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}