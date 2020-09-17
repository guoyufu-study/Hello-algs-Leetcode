package com.jasper.algs.contest.weekly.c094.qu0872.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0872. 叶子相似的树
 * 
 * <p> DFS 前序遍历
 */
class Solution {
    int index = 0;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        int[] leaf1 = new int[101];
        int[] leaf2 = new int[101];
        leafs(root1, leaf1);
        index = 0;
        leafs(root2, leaf2);
        
        for(int i=0; i<101; i++) {
            if(leaf1[i]!=leaf2[i])
                return false;
        }
        return true;
    }

    void leafs(TreeNode root, int[] leafs) {
        if(root==null) return ;
        if(root.left==null && root.right==null) leafs[index++] = root.val;
        else {
            leafs(root.left, leafs);
            leafs(root.right, leafs);
        }
    }

}