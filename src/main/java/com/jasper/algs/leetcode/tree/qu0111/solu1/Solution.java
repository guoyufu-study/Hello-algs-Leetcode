package com.jasper.algs.leetcode.tree.qu0111.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0111. 二叉树的最小深度
 * 
 * <p> 递归
 */
class Solution {
    public int minDepth(TreeNode root) {
    	if(root==null)
    		return 0;
    	
    	if(root.left==null && root.right==null) 
    		return 1;
    	
    	int minDepth = Integer.MAX_VALUE;
    	if(root.left!=null) 
    		minDepth = Math.min(minDepth, minDepth(root.left));
    	
    	if(root.right!=null) 
    		minDepth = Math.min(minDepth, minDepth(root.right));
    	
    	return minDepth + 1;
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