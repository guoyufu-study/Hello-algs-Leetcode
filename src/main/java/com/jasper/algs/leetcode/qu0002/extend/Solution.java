package com.jasper.algs.leetcode.qu0002.extend;

import com.jasper.algs.leetcode.qu0002.ListNode;

public class Solution {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// 较长一部分
		ListNode p=l1, q=l2;//跟踪节点
		while(p!=null && q !=null) {
			p = p.next;
			q = q.next;
		}
		
		ListNode dummyHead = new ListNode(0);//哑节点(逆序)
		ListNode ptmp = p, qtmp = q, cur=dummyHead;//跟踪节点
		p = l1; q = l2;
		while (ptmp!=null || qtmp!=null) {
			//新节点
			cur = ptmp!=null?new ListNode(p.val):new ListNode(q.val);//创建
			cur.next = dummyHead.next;//插入头部
			dummyHead.next = cur;
			
			//更新跟踪节点
			if(ptmp!=null) {
				p = p.next;
				ptmp = ptmp.next;
				continue;
			}
			q = q.next;
			qtmp = qtmp.next;
		}
		
		// 等长部分相加
		while(q!=null && p!=null) {
			//新节点
			cur = new ListNode((p.val+q.val));//创建
			cur.next = dummyHead.next;//插入头部
			dummyHead.next = cur;
			
			//更新跟踪节点
			p = p.next;
			q = q.next;
		}
		
		// 统一进位，并逆序
		dummyHead.next = null;
		int carry = 0; //进位
		while(cur!=null) {
			// 更新当前节点
			carry = (cur.val += carry)/10;//进位
			cur.val %= 10;// 值
			
			// 插入
			ListNode tmp = cur;
			cur = cur.next; // 更新跟踪
			tmp.next = dummyHead.next;
			dummyHead.next = tmp;
		}
		if(carry>0) {
			dummyHead.val = carry;
			return dummyHead;
		}
		
		return dummyHead.next;
	}
	
}
