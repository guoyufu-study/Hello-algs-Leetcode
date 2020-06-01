package com.jasper.algs.leetcode.tree.qu0144.solu1;

import java.util.ArrayList;
import java.util.List;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0144. 二叉树的前序遍历
 * 
 * <p> 递归实现
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

    	ArrayList<Integer> ans = new ArrayList<Integer>();
    	preorderTraversal(root, ans);
    	
    	return ans;
    }

	private void preorderTraversal(TreeNode root, ArrayList<Integer> ans) {
		if(root==null)
			return ;
		
		ans.add(root.val);
		preorderTraversal(root.left, ans);
		preorderTraversal(root.right, ans);
	}
}