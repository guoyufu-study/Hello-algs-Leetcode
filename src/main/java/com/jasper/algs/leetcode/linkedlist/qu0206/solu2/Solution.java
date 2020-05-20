package com.jasper.algs.leetcode.linkedlist.qu0206.solu2;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0206. 反转链表
 *
 * <p> 递归反转
 */
class Solution {
    public ListNode reverseList(ListNode head) {
    	// 边界
    	if(head==null || head.next==null) return head;
    	
    	// 反转
    	ListNode p = reverseList(head.next);
    	head.next.next = head;
    	head.next = null;
    	
    	return p;
    }
}