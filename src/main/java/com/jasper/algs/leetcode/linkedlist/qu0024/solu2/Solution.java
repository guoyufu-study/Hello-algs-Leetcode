package com.jasper.algs.leetcode.linkedlist.qu0024.solu2;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0024. 两两交换链表中的节点
 * 
 * <p> 迭代反转
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
    	// 边界
    	if(head==null || head.next==null)
    		return head;
    	
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	
    	// 两个一组反转
    	int count=1;
    	ListNode prev=dummy, next=head.next;
    	while(head.next!=null) {
    		if(count==1) {
    			prev.next = next;
    			prev = head;
    			head = next;
    			next = head.next;
    			head.next = prev;
    			prev.next = next;
    			count++;
    		} else {
    			count=1;
    			head = next;
    			next = head.next;
    		}
    	}
    	
    	return dummy.next;
    }
}