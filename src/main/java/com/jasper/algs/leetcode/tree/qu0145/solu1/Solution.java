package com.jasper.algs.leetcode.tree.qu0145.solu1;

import java.util.ArrayList;
import java.util.List;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0145. 二叉树的后序遍历
 * 
 * <p> 递归实现
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

    	List<Integer> ans = new ArrayList<Integer>();
    	postorderTraversal(root, ans);
    	
    	return ans;
    }

	private void postorderTraversal(TreeNode root, List<Integer> ans) {
		if(root==null)
			return ;
		
		postorderTraversal(root.left, ans);
		postorderTraversal(root.right, ans);
		ans.add(root.val);
	}
}