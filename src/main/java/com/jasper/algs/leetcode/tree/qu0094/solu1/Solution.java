package com.jasper.algs.leetcode.tree.qu0094.solu1;

import java.util.ArrayList;
import java.util.List;

import com.jasper.algs.leetcode.tree.TreeNode;


/**
 * 0094. 二叉树的中序遍历
 * 
 * <p> 递归
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

    	// 中序遍历
    	List<Integer> ans = new ArrayList<Integer>();
    	inorderTraversal(root, ans);
    	
    	return ans;
    }

	private void inorderTraversal(TreeNode root, List<Integer> ans) {
		if(root==null)
			return ;
		
		inorderTraversal(root.left, ans);
		ans.add(root.val);
		inorderTraversal(root.right, ans);
	}
}