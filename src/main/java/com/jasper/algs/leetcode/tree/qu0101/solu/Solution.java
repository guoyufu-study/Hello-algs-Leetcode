package com.jasper.algs.leetcode.tree.qu0101.solu;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0101. 对称二叉树
 * 
 * <p> 递归实现
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // 边界
    	if(root==null) return true;
    	
    	// 递归：左右子树镜像对称
    	return isSymmetric(root.left, root.right);
    	
    }
    
    /**
     * 两树镜像对象
     * 
     * @param left
     * @param right
     * @return
     */
    private boolean isSymmetric(TreeNode left, TreeNode right) {
    	
    	if(left==null && right==null) 
    		return true;
    	
    	if(left==null || right==null) 
    		return false;
    	
    	return (left.val == right.val) 
    			&& isSymmetric(left.left, right.right) 
    			&& isSymmetric(left.right, right.left);
    		
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