package com.jasper.algs.leetcode.tree.qu0098.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0098. 验证二叉搜索树
 *
 * <p> DFS（前序）
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
    	return isValidBST(root, null, null);
    }

	private boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
		if(root==null) return true;
		
		if(lower!=null && lower>=root.val) return false;
		if(upper!=null && root.val>=upper) return false;
		
		return isValidBST(root.left,  lower, root.val) && isValidBST(root.right, root.val, upper);
	}
}