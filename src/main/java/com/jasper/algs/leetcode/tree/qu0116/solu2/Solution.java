package com.jasper.algs.leetcode.tree.qu0116.solu2;

import com.jasper.algs.leetcode.tree.qu0116.Node;

/**
 * 0116. 填充每个节点的下一个右侧节点指针
 * 
 * <p> 递归
 */
class Solution {
    public Node connect(Node root) {
    	if(root==null || root.left==null) return root;

        root.left.next = root.right;
        if(root.next!=null) root.right.next = root.next.left;

        connect(root.left);
        connect(root.right);

        return root;
    }
}