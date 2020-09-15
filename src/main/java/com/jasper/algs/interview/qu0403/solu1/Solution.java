package com.jasper.algs.interview.qu0403.solu1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.jasper.algs.leetcode.linkedlist.ListNode;
import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 面试题 04.03. 特定深度节点链表
 * 
 * <p> 层序遍历
 */
class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        // 层序遍历
        List<ListNode> ans = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if(tree!=null) queue.offer(tree);
        while(!queue.isEmpty()) {
            int len = queue.size();
            ListNode tmp = new ListNode(queue.peek().val);
            ans.add(tmp);
            for(int i=0; i<len; i++) {
                TreeNode node = queue.poll();
                if(i>0) {
                    tmp.next = new ListNode(node.val);
                    tmp = tmp.next;
                }
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }

        // 构造答案
        return ans.toArray(new ListNode[ans.size()]);
    }
    
}