package com.jasper.algs.leetcode.tree.qu0116.solu3;

import com.jasper.algs.leetcode.tree.qu0116.Node;

/**
 * 0116. 填充每个节点的下一个右侧节点指针
 * 
 * <p> 利用 next 指针
 */
class Solution {
    public Node connect(Node root) {
        if(root==null) return root;

        Node leftmost = root; // 最左侧节点
        while(leftmost!=null) {
            Node head = leftmost;
            while(head!=null) {// 层序遍历
                if(head.left==null) break; // 叶节点
                head.left.next = head.right;
                if(head.next==null) break; // 最右侧节点
                head.right.next = head.next.left;

                head = head.next;
            }

            leftmost = leftmost.left; // 下一层最左侧节点
        }

        return root;
    }
}