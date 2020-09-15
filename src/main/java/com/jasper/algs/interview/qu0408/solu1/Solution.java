package com.jasper.algs.interview.qu0408.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 面试题 04.08. 首个共同祖先
 * 
 * <p> 递归
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null // 到底了还没找到，返回 null
        		|| root == p || root == q) {// 如果找到了 p 或 q，返回它
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);  // left 记录 p 或 q 是在左子树找到的
        TreeNode right = lowestCommonAncestor(root.right, p, q); // right 记录 p 或 q 是在右子树找到的
        // 如果两个都记录了找到的节点，那么肯定是一个记录了 p ，另一个记录了 q
        // 它们分别在以 root 为根的左右子树中，所以 root 就是它们的最近公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 由于节点 p,q 一定在二叉树中，left和right不会同时为null
        // 若 left != null && right == null，说明在左子树中找到了p或q，而在右子树找不到p或q，则剩下一个也在左子树
        // 所以left就是最近公共祖先
        // 另一种情况同理
        return (left != null) ? left : right;
    }
}