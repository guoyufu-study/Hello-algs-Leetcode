package com.jasper.algs.leetcode.tree.qu0107.solu;

import java.util.List;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 107. 二叉树的层次遍历 II
 * 
 * <p> 2刷
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

    	return null;
    }
    
    public static void main(String[] args) {
    	// [[15, 7], [9, 20], [3]]
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(9);
    	root.right = new TreeNode(20);
    	root.right.left = new TreeNode(15);
    	root.right.right = new TreeNode(7);
    	
		System.out.println(new Solution().levelOrderBottom(root));
	}
}