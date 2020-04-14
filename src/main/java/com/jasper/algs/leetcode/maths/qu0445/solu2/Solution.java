package com.jasper.algs.leetcode.maths.qu0445.solu2;

import java.util.Random;
import java.util.Stack;

import com.jasper.algs.leetcode.maths.qu0445.ListNode;

/**
 * 两个加数辅助栈
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    	ListNode dummyNode = new ListNode(0);// 哑节点
    	Stack<Integer> s1 = createStackHelper(l1);//被加数辅助栈
    	Stack<Integer> s2 = createStackHelper(l2);//加数辅助栈
    	int carry = 0; // 跟踪进位
    	
    	while(s1.peek()>-1 || s2.peek()>-1 || carry != 0) {
    		// 相加求值
    		int x = s1.peek()>-1? s1.pop(): 0;
    		int y = s2.peek()>-1? s2.pop(): 0;
    		int sum = carry + x +y;
    		
    		// 更新进位
    		carry = sum/10;
    		
    		// 头插
    		ListNode curr = new ListNode(sum%10);
    		curr.next = dummyNode.next;
    		dummyNode.next = curr;
    	}
    	
    	return dummyNode.next;
    }
    
    // 构造辅助栈
    private Stack<Integer> createStackHelper(ListNode l) {
    	Stack<Integer> helper = new Stack<>();
    	helper.push(-1);// 哨兵
    	while(l!=null) {
    		helper.push(l.val);
    		l = l.next;
    	}
    	return helper;
    }
    
    public static void main(String[] args) {
		ListNode l1 = new Solution().createListNode(9);
		ListNode l2 = new Solution().createListNode(11);
		
		ListNode ans = new Solution().addTwoNumbers(l1,l2);
		new Solution().print(ans);
		
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
		
		print(dummyNode.next);
		
		return dummyNode.next;
    }
    
    
    private void print(ListNode l) {
    	while(l!=null) {
    		System.out.printf("%d -> ", l.val);
    		l = l.next;
    	}
    	System.out.println();
    }
}