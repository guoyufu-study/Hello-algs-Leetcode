package com.jasper.algs.leetcode.tree.qu0637.solu;

import java.util.List;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0637. 二叉树的层平均值
 * 
 * <p> 2刷
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {

    	return null;
    }
    
    public static void main(String[] args) {
    	// [3, 14.5, 11]
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(9);
    	root.right = new TreeNode(20);
    	root.right.left = new TreeNode(15);
    	root.right.right = new TreeNode(7);
    	
		System.out.println(new Solution().averageOfLevels(root));
	}
}