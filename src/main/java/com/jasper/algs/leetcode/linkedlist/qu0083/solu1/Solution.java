package com.jasper.algs.leetcode.linkedlist.qu0083.solu1;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0083. 删除排序链表中的重复元素
 * 
 * <p> 保留最后一个元素
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {

    	// 边界
    	if(head==null) return head;
    	
    	ListNode dummy = new ListNode(head.val-1);
    	ListNode tail = dummy;
    	while(head!=null) {
    		// 跳过重复元素
    		if(head.next==null || head.val != head.next.val) {
    			tail.next = head;
    			tail = head;
    		}
    		
    		head = head.next;
    	}
    	
    	return dummy.next;
    }
}