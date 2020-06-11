package com.jasper.algs.sword2offer.qu1660.solu1;

/**
 * 1660. 面试题62. 圆圈中最后剩下的数字
 * 
 * <p> 暴力模拟（超时）
 */
class Solution {
    public int lastRemaining(int n, int m) {
    	// 边界
    	if(m==1) return n-1;
    	
    	// 构造数据
    	Node head = new Node(0);
    	Node cur = head;
    	for (int i = 1; i < n; i++) {
    		cur.next = new Node(i);
    		cur = cur.next;
		}
    	cur.next = head;
    	cur = cur.next;
    	
    	// 报数删除
    	while(cur.next!=cur) {
    		int count = 1;
    		while(count<m-1) {
    			cur = cur.next;
    			count++;
    		}

    		cur.next = cur.next.next;
    		cur = cur.next;
    	}
    	
    	return cur.x;
    }

    class Node {
    	int x;
    	Node next;
    	Node(int x) {
    		this.x = x;
    	}
    	
    	int getX() {
    		return x;
    	}
    	
    	Node next() {
    		return next;
    	}
    }
    
    
    public static void main(String[] args) {
    	// 3
//    	int n = 5, m = 3;
    	
    	// 2
//    	int n = 10, m = 17;
    	
    	// 64165
    	int n = 70866, m = 116922;
    	
    	System.out.println(new Solution().lastRemaining(n, m));
	}
    
}