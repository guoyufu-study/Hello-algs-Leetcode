package com.jasper.algs.leetcode.linkedlist.qu0019.solu2;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0019. 删除链表的倒数第N个节点
 *
 * <p> 左右指针
 */
class Solution {
	@SuppressWarnings("null")
	public ListNode removeNthFromEnd(ListNode head, int n) {
    	
    	// 简化删除头节点问题
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	
    	// 先走n+1步
    	ListNode slow = dummy, fast = dummy;
    	for (int i = 0; i <= n; i++) {
			fast = fast.next;
		}
    	
    	// 保持 n 个间距，一起走
    	while(slow!=null) {
    		fast = fast.next;
    		slow = slow.next;
    	}
    	
    	// 找到倒数第n+1个节点，删除下一个节点
    	slow.next = slow.next.next;
    	
    	return dummy.next;
    }
}
