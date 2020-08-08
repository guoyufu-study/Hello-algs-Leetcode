package com.jasper.algs.leetcode.linkedlist.qu0082.solu1;

import java.util.HashMap;
import java.util.Map;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0082. 删除排序链表中的重复元素 II
 * 
 * <p> 辅助字典计数
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	
    	// 边界
    	if(head == null || head.next == null) 
    		return head;
    	
    	// 计数
    	ListNode current = head;
    	Map<Integer,Integer> map = new HashMap<Integer, Integer>();
    	while(current != null) {
    		map.compute(current.val, (key, val)->val==null ? 1 : val+1);
    	}
    	
    	// 找出非重复元素，构造答案
    	ListNode dummy = new ListNode(0);
    	ListNode tail = dummy;
    	current = head;
    	while(current != null) {
    		if(map.get(current.val)==1) {
    			tail.next = current;
    			tail = current;
    		}
    	}
    	tail.next = null;
    	
    	return dummy.next;
    }
}