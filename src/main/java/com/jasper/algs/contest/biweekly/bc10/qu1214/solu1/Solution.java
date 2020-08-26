package com.jasper.algs.contest.biweekly.bc10.qu1214.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 1214. 查找两棵二叉搜索树之和
 * 
 * <p> 暴力查找
 */
class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1==null || root2==null)
            return false;
        int val = target - root1.val;
        
        return search(root2, val) || twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1.right, root2, target);
    }
    
    boolean search(TreeNode root, int val) {
        if(root==null)
            return false;
        if(root.val==val)
            return true;
        
        if(root.val > val) return search(root.left, val);
        
        return search(root.right, val);
    }
}