package com.jasper.algs.leetcode.maths.qu0002.solu1;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * <p>思路清晰！！！
 * <p> 技巧1：使用空对象模式（哑节点）
 * <p> 技巧2：分开判断
 */
public class Solution {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0);//哑节点
	    ListNode p = l1, q = l2, curr = dummyHead; // //跟踪节点
	    int carry = 0;//跟踪进位
	    
	    while (p != null || q != null) {
	    	// 计算
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        
	        // 更新跟踪
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    
	    if (carry > 0) {//进位
	        curr.next = new ListNode(carry);
	    }
	    
	    return dummyHead.next;
	}

}
