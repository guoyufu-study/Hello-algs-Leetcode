package com.jasper.algs.leetcode.linkedlist.qu0328.solu1;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0328. 奇偶链表
 *
 * <p> 自画图理解
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
    	// 边界
    	if(head==null) return head;
    	
    	ListNode odd=head, even=head.next, evenHead=even;
    	while(even!=null && even.next!=null) {
    		odd = odd.next = even.next;
    		even = even.next = odd.next;
    	}
    	odd.next = evenHead;
    	
		return head;
    }
}