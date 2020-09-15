package com.jasper.algs.interview.qu0406.solu4;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 面试题 04.06. 后继者
 * 
 * <p> BST + 非递归
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    	if(root==null) return null;
    	TreeNode ans = null, node = root;
    	while(node!=null) {
    		if(p.val >= node.val) node = node.right; // 右子树
    		else {
    			ans = node; // 自身
    			node = node.left; // 左子树
    		}
    	}
    	return ans;
    }
}