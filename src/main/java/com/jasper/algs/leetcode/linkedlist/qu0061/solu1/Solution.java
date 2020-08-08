package com.jasper.algs.leetcode.linkedlist.qu0061.solu1;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0061. 旋转链表
 * 
 * <p> 先构造环，再找新头尾断开
 */
class Solution {

	public ListNode rotateRight(ListNode head, int k) {

		if(k==0 || head==null || head.next==null)
			return head;
		
		// 构造环
		ListNode p = head;
		int size = 0;
		while(p.next != null) {
			p = p.next;
			size++;
		}
		p.next = head;
		size++;
		
		// 找新头尾
		k = k % size;
		int prev = size - k;
		for (int i = 0; i < prev; i++) {
			p = p.next;
		}
		head = p.next;
		p.next = null;
		
		return head;
    }
	
}
