package com.jasper.algs.leetcode.tree.qu0987.solu;

import java.util.List;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0987. 二叉树的垂序遍历
 * 
 * <p> 2刷
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

    	return null;
    }
    
    public static void main(String[] args) {
    	// [[9], [3, 15], [20], [7]]
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(9);
    	root.right = new TreeNode(20);
    	root.right.left = new TreeNode(15);
    	root.right.right = new TreeNode(7);
    	
		System.out.println(new Solution().verticalTraversal(root));
	}
}