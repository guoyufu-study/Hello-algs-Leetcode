package com.jasper.algs.leetcode.linkedlist.qu0019.solu2;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0019. 删除链表的倒数第N个节点
 *
 * <p> 双指针
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	
    	// 简化删除头节点问题
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	
    	// 先走n+1步
    	ListNode first = dummy;
    	ListNode second = dummy;
    	for (int i = 0; i <= n; i++) {
			first = first.next;
		}
    	
    	// 保持 n 个间距，一起走
    	while(first!=null) {
    		first = first.next;
    		second = second.next;
    	}
    	
    	// 找到倒数第n+1个节点，删除下一个节点
    	second.next = second.next.next;
    	
    	return dummy.next;
    }
}
