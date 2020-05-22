package com.jasper.algs.leetcode.linkedlist.qu0019.solu1;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0019. 删除链表的倒数第N个节点
 *
 * <p> 删除第L-N+1个节点
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	// 简化删除头节点问题
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	
    	// 计算长度
    	int lenght = 0;
    	ListNode first = head;
    	while(first!=null) {
    		lenght++;
    		first = first.next;
    	}
    	
    	// 找到倒数第N+1个节点，即第L-N个节点
    	first = dummy;
    	int N = lenght - n;
    	for (int i = 1; i <= N; i++) {
			first = first.next;
		}
    	
    	// 删除下一个节点
    	first.next = first.next.next;
    	
    	return dummy.next;
    }
}
