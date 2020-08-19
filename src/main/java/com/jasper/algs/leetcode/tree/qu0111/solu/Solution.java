package com.jasper.algs.leetcode.tree.qu0111.solu;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0111. 二叉树的最小深度
 * 
 * <p> 5刷
 */
class Solution {
    public int minDepth(TreeNode root) {

    	return 0;
    }
    
    public static void main(String[] args) {
    	// 2
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(9);
    	root.right = new TreeNode(20);
    	root.right.left = new TreeNode(15);
    	root.right.right = new TreeNode(7);
    	
		System.out.println(new Solution().minDepth(root));
	}
}