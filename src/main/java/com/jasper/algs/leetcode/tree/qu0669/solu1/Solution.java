package com.jasper.algs.leetcode.tree.qu0669.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0669. 修剪二叉搜索树
 *
 * <p> DFS（先序遍历）
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {

    	if(root==null) return root;
    	
    	if(root.val<L) return trimBST(root.right, L, R);
    	if(root.val>R) return trimBST(root.left, L, R);
    	
    	root.left = trimBST(root.left, L, R);
    	root.right = trimBST(root.right, L, R);
    	return root;
    }
}