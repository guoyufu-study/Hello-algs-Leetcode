package com.jasper.algs.leetcode.linkedlist.qu0082.solu2;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0082. 删除排序链表中的重复元素 II
 * 
 * <p> 前后比较
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	
    	// 边界
    	if(head == null || head.next == null) 
    		return head;
    	
    	ListNode dummy = new ListNode(0);// 答案
    	ListNode tail = dummy;
    	
    	// 找出非重复值，构造答案
    	int sameVal = head.val-1;
    	ListNode current = head;
    	while(current != null) {
    		if(sameVal == current.val) {//前比较
    			// do nothing
    		} else if(current.next != null && current.val == current.next.val) { // 后比较
    			sameVal = current.val;
    		} else {
    			// 直接构造
    			tail.next = current;
    			tail = tail.next;
    		}
    		current = current.next;
    	}
    	tail.next = null;
    	
    	return dummy.next;
    }
}