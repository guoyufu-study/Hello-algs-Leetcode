package com.jasper.algs.leetcode.tree.qu0117.solu2;

import com.jasper.algs.leetcode.tree.qu0116.Node;

/**
 * 0117. 填充每个节点的下一个右侧节点指针 II
 * 
 * <p> 利用 next 指针
 */
class Solution {

    Node last, nextleftmost;
    public Node connect(Node root) {
        if (root == null) return null;
        
        Node leftmost = root;
        while (leftmost != null) {
            last = null;
            nextleftmost = null;
            for (Node p = leftmost; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            leftmost = nextleftmost;
        }
        return root;
    }

    public void handle(Node p) {
        if (last != null) {
            last.next = p;
        } 
        if (nextleftmost == null) {
            nextleftmost = p;
        }
        last = p;
    }
}