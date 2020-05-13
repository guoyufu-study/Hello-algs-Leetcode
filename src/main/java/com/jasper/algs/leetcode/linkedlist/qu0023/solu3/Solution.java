package com.jasper.algs.leetcode.linkedlist.qu0023.solu3;

import java.util.PriorityQueue;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0023. 合并K个排序链表
 *
 * <p>优先级队列
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
    	
    	ListNode dummy = new ListNode(0);
    	ListNode prev = dummy;
    	
    	// 最小堆
    	PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> {
    		return a.val - b.val;
    	});
    	for (int i = 0; i < lists.length; i++) {
    		if(lists[i]!=null) {
    			queue.offer(lists[i]);
    		}
		}
    	
    	// 合并
    	while(!queue.isEmpty()) {
    		prev.next = queue.poll();
    		prev = prev.next;
    		if(prev.next!=null)
    			queue.offer(prev.next);
    	}
    	
    	return dummy.next;
    }
}