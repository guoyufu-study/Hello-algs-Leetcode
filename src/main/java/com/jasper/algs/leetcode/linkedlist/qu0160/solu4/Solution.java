package com.jasper.algs.leetcode.linkedlist.qu0160.solu4;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0160. 相交链表
 * 
 * <p> 双指针：简化
 */
public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		// 把 null 结点，也加入比较中
        ListNode a = headA, b = headB;
        while(a!=b) {
        	a = a==null ? headB : a.next;
        	b = b==null ? headA : b.next;
        }
        
        return a;
    }
}
