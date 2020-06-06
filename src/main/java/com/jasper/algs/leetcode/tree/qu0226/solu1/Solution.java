package com.jasper.algs.leetcode.tree.qu0226.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0226. 翻转二叉树
 * 
 * <p> 迭代实现
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
    	
    	// 边界
    	if(root==null) 
    		return root;
    	
    	// 翻转左右子树
    	TreeNode left = invertTree(root.left);
    	TreeNode right = invertTree(root.right);
    	
    	// 翻转左右节点
    	root.left = right;
    	root.right = left;
    	
    	return root;
    }
}