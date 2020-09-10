package com.jasper.algs.leetcode.tree.qu0404.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0404. 左叶子之和
 * 
 * <p> 递归
 */
class Solution {
    
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        return sumOfLeftLeaves(root.left) 
            + sumOfLeftLeaves(root.right) 
            + (root.left!=null && root.left.left==null && root.left.right==null ? root.left.val : 0);
    }
}