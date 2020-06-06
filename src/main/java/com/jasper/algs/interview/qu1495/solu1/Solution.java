package com.jasper.algs.interview.qu1495.solu1;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 1495.面试题 02.01. 移除重复节点
 * 
 * <p> 辅助字典
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
    	
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	
    	// 辅助字典：标记已有值
    	boolean[] cache = new boolean[20_001];
    	
    	ListNode prev = dummy;
    	while(head!=null) {
    		
    		// 移除值重复节点
    		if(cache[head.val]) {
    			prev.next = head.next;
    			
    		// 跳过非重复节点
    		} else {
    			cache[head.val] = true;
    			prev = head;
    		}
    		
    		head = head.next;
    	}
    	
    	return dummy.next;
    }
}
