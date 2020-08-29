package com.jasper.algs.contest.weekly.c095.qu0876.solu1;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	/**
	 * 快慢指针
	 */
    public ListNode middleNode(ListNode head) {
    	ListNode slow=head, fast=head;
    	
    	// 长度为奇数/偶数，都没问题
    	while(fast!=null && fast.next!=null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	
		return slow;
    }
}