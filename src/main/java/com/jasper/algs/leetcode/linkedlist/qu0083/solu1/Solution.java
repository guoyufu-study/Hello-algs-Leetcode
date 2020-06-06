package com.jasper.algs.leetcode.linkedlist.qu0083.solu1;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0083. 删除排序链表中的重复元素
 * 
 * <p> 哨兵
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {

    	// 边界
    	if(head==null) return head;
    	
    	// 哨兵
    	ListNode dummy = new ListNode(head.val-1);
    	dummy.next = head;
    	
    	// 前驱
    	ListNode prev = dummy;
    	while(head!=null) {
    		// 删除重复元素
    		if(head.val == prev.val) {
    			prev.next = head.next;
    		
    		// 跳过不重复元素
    		} else {
    			prev = head;
    		}
    		
    		head = head.next;
    	}
    	
    	return dummy.next;
    }
}