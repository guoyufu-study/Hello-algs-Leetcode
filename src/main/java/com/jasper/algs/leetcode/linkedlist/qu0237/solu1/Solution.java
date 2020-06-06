package com.jasper.algs.leetcode.linkedlist.qu0237.solu1;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0237. 删除链表中的节点
 * 
 * <p> 2 刷
 */
class Solution {
	
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    
}