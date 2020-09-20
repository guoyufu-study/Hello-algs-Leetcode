package com.jasper.algs.leetcode.tree.qu0156.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0156. 上下翻转二叉树
 * 
 * <p> DFS 中后序
 */
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null) return null;
        if(root.left==null) return root;
        TreeNode finalRoot = upsideDownBinaryTree(root.left); 
        TreeNode newRoot = root.left;// 新根 <- 左节点
        newRoot.left = root.right; // 左节点 <- 左节点
        newRoot.right = root; // 右节点 <- 老根
        root.left = root.right = null; // 叶子节点 <- 新右节点
        return finalRoot;
    }
}