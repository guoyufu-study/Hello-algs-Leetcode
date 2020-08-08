package com.jasper.algs.leetcode.bitmanipulation.qu1290.solu1;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 1290. 二进制链表转整数
 * 
 * <p> 模拟
 */
class Solution {
	
    public int getDecimalValue(ListNode head) {
    	ListNode p = head;
    	int ans = 0;
    	while (p!=null) {
    		ans = (ans<<1) + p.val;
    		p = p.next;
    	}
    	return ans;
    }
    
}