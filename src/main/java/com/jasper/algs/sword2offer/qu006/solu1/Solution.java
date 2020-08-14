package com.jasper.algs.sword2offer.qu006.solu1;

import java.util.Deque;
import java.util.LinkedList;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 1558.剑指 Offer 06. 从尾到头打印链表
 *
 * <p> 辅助栈
 */
class Solution {
	
    public int[] reversePrint(ListNode head) {
    	ListNode p = head;
    	Deque<ListNode> stack = new LinkedList<ListNode>();
    	while(p!=null) {
    		stack.push(p);
    		p = p.next;
    	}
    	
    	int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }
}