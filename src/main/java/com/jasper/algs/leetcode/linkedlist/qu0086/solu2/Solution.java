package com.jasper.algs.leetcode.linkedlist.qu0086.solu2;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0086. 分隔链表
 * 
 * <p> 双指针
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
    	ListNode before_head = new ListNode(0);
    	ListNode after_head = new ListNode(0);
    	ListNode before = before_head, after = after_head;
    	
    	while(head != null) {
    		if(head.val < x) {// 小值
    			before.next = head;
    			before = before.next;
    		} else {// 大值
    			after.next = head;
    			after = after.next;
    		}
    		// 步进原链表
    		head = head.next;
    	}
    	
    	// 连接两个链表
    	after.next = null;
    	before.next = after_head.next;
    	return before_head.next;
    }
}
