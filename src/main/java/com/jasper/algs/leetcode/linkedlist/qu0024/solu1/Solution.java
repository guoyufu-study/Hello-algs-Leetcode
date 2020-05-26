package com.jasper.algs.leetcode.linkedlist.qu0024.solu1;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0024. 两两交换链表中的节点
 * 
 * <p> 递归反转
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
    	// 边界
    	if(head==null || head.next==null)
    		return head;
    	
    	// 两个一组反转
    	ListNode second = head.next;
    	head.next = swapPairs(second.next);
    	second.next = head;
    	
    	return second;
    }
}