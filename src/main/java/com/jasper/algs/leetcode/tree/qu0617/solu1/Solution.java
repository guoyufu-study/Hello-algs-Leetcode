package com.jasper.algs.leetcode.tree.qu0617.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0617. 合并二叉树
 * 
 * <p> 递归实现（先序遍历）
 */
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    	
        if(t1==null) return t2;
        if(t2==null) return t1;
        
        // 合并
        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);

        return node;
    }
}