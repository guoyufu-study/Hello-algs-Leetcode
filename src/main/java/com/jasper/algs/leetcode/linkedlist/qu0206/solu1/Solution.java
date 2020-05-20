package com.jasper.algs.leetcode.linkedlist.qu0206.solu1;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0206. 反转链表
 *
 * <p> 迭代反转
 */
class Solution {
    public ListNode reverseList(ListNode head) {
    	// 边界
    	if(head==null) return head;
    	
    	ListNode prev=null, next=head.next;
    	
    	while(next!=null) {
    		head.next = prev;
    		prev = head;
    		head = next;
    		next = head.next;
    	}
    	
    	head.next = prev;
    	
    	return head;
    	
    }
}