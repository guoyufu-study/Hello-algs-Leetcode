package com.jasper.algs.leetcode.linkedlist.qu0203.solu1;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0203. 移除链表元素
 * 
 * <p> 哨兵
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
    	// 哨兵
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	
    	// 前一个节点、当前节点
    	ListNode prev = dummy;
    	while(head!=null) {
    		// 删除节点
    		if(head.val==val) {
    			prev.next = head.next;
    		
    		// 跳过节点
    		} else {
    			prev = head;
    		}
    		
    		head = head.next;
    	}
    	
    	return dummy.next;
    }
    
}