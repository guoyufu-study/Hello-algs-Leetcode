package com.jasper.algs.interview.qu0406.solu3;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 面试题 04.06. 后继者
 * 
 * <p> BST + 递归
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    	if(root==null) return null;
    	// 右子树
    	if(p.val >= root.val) return inorderSuccessor(root.right, p);
    	// 左子树 或 自身
    	TreeNode node = inorderSuccessor(root.left, p);
    	return node==null ? root : node;
    }
}