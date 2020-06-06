package com.jasper.algs.leetcode.tree.qu0100.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0100. 相同的树
 * 
 * <p> 递归
 */
class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        // 边界
		if(p==null && q==null) return true;
		if(p==null || q==null) return false;
		
		return p.val==q.val // 值
				&& isSameTree(p.left, q.left) // 左子树
				&& isSameTree(p.right, q.right);	// 右子树
		
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