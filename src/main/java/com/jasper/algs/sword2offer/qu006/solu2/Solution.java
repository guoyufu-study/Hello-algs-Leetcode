package com.jasper.algs.sword2offer.qu006.solu2;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 1558.剑指 Offer 06. 从尾到头打印链表
 *
 * <p> 直接计数
 */
class Solution {
	
    public int[] reversePrint(ListNode head) {
    	ListNode p = head;
    	int size = 0;
    	while(p!=null) {
    		p = p.next;
    		size++;
    	}
    	
        int[] print = new int[size];
        p = head;
        for (int i = size-1; i >= 0; i--, p=p.next) {
            print[i] = p.val;
        }
        return print;
    }
}