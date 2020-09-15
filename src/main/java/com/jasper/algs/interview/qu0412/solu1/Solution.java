package com.jasper.algs.interview.qu0412.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 面试题 04.12. 求和路径
 * 
 * <p> 回溯
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        int dep = depth(root);
        int[] paths = new int[dep];
        pathSum(root, sum, 0, paths);
        return res;
    }

    int res = 0;

    public void pathSum(TreeNode root, int sum, int level, int[] paths) {
        if (root == null) {
            return;
        }
        paths[level] = root.val;
        int t = 0;
        for (int i = level; i >= 0; i--) {
            t += paths[i];
            if (t == sum) {
                res += 1;
            }
        }
        pathSum(root.left, sum, level + 1, paths);
        pathSum(root.right, sum, level + 1, paths);
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}