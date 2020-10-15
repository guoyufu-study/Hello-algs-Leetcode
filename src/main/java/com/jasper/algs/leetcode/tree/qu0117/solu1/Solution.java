package com.jasper.algs.leetcode.tree.qu0117.solu1;

import java.util.LinkedList;
import java.util.Queue;

import com.jasper.algs.leetcode.tree.qu0116.Node;

/**
 * 0117. 填充每个节点的下一个右侧节点指针 II
 * 
 * <p> 辅助队列
 */
class Solution {
    public Node connect(Node root) {
    	if (root == null) return root;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            Node last = null;
            for (int i = 1; i <= len; ++i) {
                Node f = queue.poll();
                if (f.left != null) queue.offer(f.left); // 左子节点入队
                if (f.right != null) queue.offer(f.right); // 右子节点入队
                if (last != null) last.next = f; // 连接节点
                last = f;
            }
        }
        return root;
    }
}