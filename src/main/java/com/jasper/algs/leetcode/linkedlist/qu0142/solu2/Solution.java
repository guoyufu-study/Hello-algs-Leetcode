package com.jasper.algs.leetcode.linkedlist.qu0142.solu2;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0141. 环形链表
 *
 * <p>快慢指针
 */
public class Solution {
	public ListNode detectCycle(ListNode head) {
        
    	ListNode slow = head;
    	ListNode fast = head;
    	
    	// 判断是否相遇
    	while(fast!=null && fast.next!=null) {
    		slow = slow.next;
    		fast = fast.next.next;
    		if(slow==fast) // 快慢指针相遇
    			break;
    	}
    	
    	// 不相遇
    	if(fast==null || fast.next==null) return null;
    	
    	// 交点
    	fast = head;
    	while(fast!=slow) {
    		fast = fast.next;
    		slow = slow.next;
    	}
    		
    	return fast;
    }
}