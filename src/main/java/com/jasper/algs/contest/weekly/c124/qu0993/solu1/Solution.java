package com.jasper.algs.contest.weekly.c124.qu0993.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0993. 二叉树的堂兄弟节点
 * 
 * <p> DLR
 */
class Solution {
    
    int[] depth;
    TreeNode[] parent;

    public boolean isCousins(TreeNode root, int x, int y) {
        depth = new int[101];
        parent = new TreeNode[101];
        dlr(root, null, 0);
        return depth[x]==depth[y] && parent[x]!=parent[y];
    }

    void dlr(TreeNode node, TreeNode p, int d) {
        if(node==null) return;
        depth[node.val] = d;
        parent[node.val] = p;
        dlr(node.left, node, d+1);
        dlr(node.right, node, d+1);
    }

}