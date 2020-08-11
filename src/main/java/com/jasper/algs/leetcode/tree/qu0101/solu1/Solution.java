package com.jasper.algs.leetcode.tree.qu0101.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0101. 对称二叉树
 * 
 * <p> 3刷
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
    	return false;
    }
    
    public static void main(String[] args) {
    	// [[9], [3, 15], [20], [7]]
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(9);
    	root.right = new TreeNode(20);
    	root.right.left = new TreeNode(15);
    	root.right.right = new TreeNode(7);
    	
		System.out.println(new Solution().isSymmetric(root));
	}
}