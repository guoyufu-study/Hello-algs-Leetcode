package com.jasper.algs.leetcode.linkedlist.qu0025.solu;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0025. K 个一组翻转链表
 * 
 * <p> 3 刷
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
    	return k==1 ? head : reverse(head, k);
    }

	private ListNode reverse(ListNode head, int k) {
		// < k
		int count = 0;
		ListNode curr = head;
		while(curr != null) {
			curr = curr.next;
			count++;
		}
		if(count < k) return head;
		
		// >= k
		count = 0;
		curr = head;
		ListNode prev = null, next = head.next;
		while(count < k) {
			curr.next = prev;
			
			prev = curr;
			curr = next;
			if(next!=null)
				next = next.next;
			count++;
		}
		
		head.next = reverse(curr, k);
		return prev;
	}
}