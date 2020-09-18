package com.jasper.algs.leetcode.tree.qu0250.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0250. 统计同值子树
 * 
 * <p> DFS 后序遍历
 */
class Solution {
    int ans;
    public int countUnivalSubtrees(TreeNode root) {
        // 后序遍历
        univalSubtrees(root);

        return ans;
    }

    boolean univalSubtrees(TreeNode root) {
        if(root==null) return true;

        // 左子树
        boolean left = univalSubtrees(root.left);
        // 右子树
        boolean right = univalSubtrees(root.right);
        // 有一个不是同值子树
        if(!left || !right) return false; 
        
        // 根 vs 左子树根 vs 右子树根
        if(root.left!=null) 
            if(root.val!=root.left.val) return false;
        if(root.right!=null) 
            if(root.val!=root.right.val) return false;
        
        ans++;

        return true;

    }

}