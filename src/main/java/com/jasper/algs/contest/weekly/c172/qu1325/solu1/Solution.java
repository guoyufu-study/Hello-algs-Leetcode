package com.jasper.algs.contest.weekly.c172.qu1325.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 1325. 删除给定值的叶子节点
 * 
 * <p> 后序遍历 LRD
 */
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null) return root;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if(root.left==null && root.right==null && root.val==target)
        	return null;
    	return root;
    }
}