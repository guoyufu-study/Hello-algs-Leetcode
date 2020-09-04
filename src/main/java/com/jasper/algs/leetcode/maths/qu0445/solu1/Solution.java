package com.jasper.algs.leetcode.maths.qu0445.solu1;

import java.util.Random;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0445.两大数相加 II（正序链表）
 * 
 * <p>翻转求和，再翻转
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    	ListNode dummyNode = new ListNode(0);// 哑节点
    	ListNode curr = dummyNode;//跟踪结果
    	ListNode p = reverse(l1), q = reverse(l2); // 跟踪加数、被加数
    	int carry = 0; // 跟踪进位
    	
    	while(p!=null || q!=null) {
    		// 值相加
    		int x = p!=null?p.val:0;
    		int y = q!=null?q.val:0;
    		int sum = carry + x + y;
    		
    		// 更新
    		curr = curr.next = new ListNode(sum%10);
    		p = p!=null?p.next:null;
    		q = q!=null?q.next:null;
    		carry = sum/10;
    	}
    	
    	if(carry>0) 
    		curr.next = new ListNode(carry);
    	
    	return reverse(dummyNode.next);
    }
    
    // 翻转链表
    private ListNode reverse(ListNode l) {
//    	System.out.print("翻转前：");
//    	ListNode p = l;
//		while(p!=null) {
//			System.out.printf("%d -> ",p.val);
//			p = p.next;
//		}
//		System.out.println();
		
    	// 边界
		if(l==null) return l;
		
		// 反转
    	ListNode prev = null, next = l.next;
    	while(next!=null) {
    		l.next = prev;
    		prev = l;
    		l = next;
    		next = l.next;
    	}
    	l.next = prev;
    	
//    	System.out.print("翻转后：");
//    	p = prev;
//		while(p!=null) {
//			System.out.printf("%d -> ",p.val);
//			p = p.next;
//		}
//		System.out.println();
		
    	return l;
    }
    
    public static void main(String[] args) {
		ListNode l1 = new Solution().createListNode(9);
		ListNode l2 = new Solution().createListNode(11);
		
		new Solution().addTwoNumbers(l1,l2);
		
	}
    
    private ListNode createListNode(int n) {
    	ListNode dummyNode = new ListNode(0);
		ListNode p = dummyNode;
		
		Random random = new Random();
		
		for (int i = 0; i < n; i++) {
			int digit = random.nextInt(10);
			p.next = new ListNode(digit);
			p = p.next;
		}
		return dummyNode.next;
    }
}