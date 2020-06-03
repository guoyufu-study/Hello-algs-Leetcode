package com.jasper.algs.leetcode.tree.qu0314.solu;

import java.util.List;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0314. 二叉树的垂直遍历
 * 
 * <p> 2刷
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
    	return null;
    }
    
    public static void main(String[] args) {
    	// [[15, 7], [9, 20], [3]]
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(9);
    	root.right = new TreeNode(20);
    	root.right.left = new TreeNode(15);
    	root.right.right = new TreeNode(7);
    	
		System.out.println(new Solution().verticalOrder(root));
	}
}