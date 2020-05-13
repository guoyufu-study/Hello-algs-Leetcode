package com.jasper.algs.leetcode.linkedlist.qu0141.solu2;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0141. 环形链表
 *
 * <p>快慢指针
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
    	ListNode slow = head;
    	ListNode fast = head;
    	
    	while(fast!=null && fast.next!=null) {
    		slow = slow.next;
    		fast = fast.next.next;
    		if(slow==fast) // 快慢指针相遇
    			return true;
    	}
    	
    	return false;
    }
}