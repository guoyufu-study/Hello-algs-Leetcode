package com.jasper.algs.leetcode.tree.qu0102.solu;

import java.util.List;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0102. 二叉树的层序遍历
 * 
 * <p> 2刷
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

    	return null;
    }
    
    public static void main(String[] args) {
    	// [[3], [9, 20], [15, 7]]
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(9);
    	root.right = new TreeNode(20);
    	root.right.left = new TreeNode(15);
    	root.right.right = new TreeNode(7);
    	
		System.out.println(new Solution().levelOrder(root));
	}
}