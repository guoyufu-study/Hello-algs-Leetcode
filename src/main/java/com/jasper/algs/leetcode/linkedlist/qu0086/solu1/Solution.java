package com.jasper.algs.leetcode.linkedlist.qu0086.solu1;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0086. 分隔链表
 * 
 * <p> 移动小节点
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
    	ListNode dummy = new ListNode(x-1);
    	dummy.next = head;
    	ListNode prev = null, next=null, current = dummy;
    	
    	// 找到第一个大值
    	boolean findedPrev = false;
    	while(current != null && current.next != null) {
    		if(findedPrev) break;
    		if(!findedPrev && current.next.val >= x) {
    			findedPrev = true;
    			prev = current;
    			next = current.next;
    		}
    		current = current.next;
    	}
    	
    	// 已到尾部
    	if(current.next==null) 
    		return dummy.next;
    	
    	// 未到尾部
    	while(current != null) {
    		if(current.next != null && current.next.val < x) {// 小值 => 前插
    			prev.next = current.next;
    			current.next = current.next.next;
    			prev = prev.next;
    			prev.next = next;
    		} else {// 大值 => 不动
    			current = current.next;
    		}
    	}
    	return dummy.next;
    }
}
