package com.jasper.algs.leetcode.tree.qu0100.solu;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0100. 相同的树
 * 
 * <p> 2刷
 */
class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        
    	return false;
    }
    
    public static void main(String[] args) {
    	// true
    	TreeNode p = new TreeNode(3);
    	p.left = new TreeNode(9);
    	p.right = new TreeNode(20);
    	p.right.left = new TreeNode(15);
    	p.right.right = new TreeNode(7);
    	
    	TreeNode q = new TreeNode(3);
    	q.left = new TreeNode(9);
    	q.right = new TreeNode(20);
    	q.right.left = new TreeNode(15);
    	q.right.right = new TreeNode(7);
    	
		System.out.println(new Solution().isSameTree(p, q));
	}
}