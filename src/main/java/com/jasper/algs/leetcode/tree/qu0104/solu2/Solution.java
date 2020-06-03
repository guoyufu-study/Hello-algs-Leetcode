package com.jasper.algs.leetcode.tree.qu0104.solu2;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0104. 二叉树的最大深度
 * 
 * <p> 递归
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        return Math.max(leftMax, rightMax) + 1;
    }
    
    public static void main(String[] args) {
    	// 3
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(9);
    	root.right = new TreeNode(20);
    	root.right.left = new TreeNode(15);
    	root.right.right = new TreeNode(7);
    	
		System.out.println(new Solution().maxDepth(root));
	}
}