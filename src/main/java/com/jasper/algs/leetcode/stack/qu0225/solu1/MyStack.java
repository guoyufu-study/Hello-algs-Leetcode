package com.jasper.algs.leetcode.stack.qu0225.solu1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 0225. 用队列实现栈
 * 
 * <p>两个队列，压入 -O(1)， 弹出 -O(n)
 */
class MyStack {
	
	private Queue<Integer> q1;
	private Queue<Integer> q2;
	private int top;

    /** 初始化数据结构 */
    public MyStack() {
    	q1 = new LinkedList<>();
    	q2 = new LinkedList<>();
    }
    
    /** 入栈 */
    public void push(int x) {
    	q1.add(x);
    	top = x;
    }
    
    /** 出栈 */
    public int pop() {
		while (q1.size() > 1) {
		    top = q1.remove();
		    q2.add(top);
		}
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		
		return q2.remove();
    }
    
    /** 栈顶元素 */
    public int top() {
    	return top;
    }
    
    /** 判空 */
    public boolean empty() {
    	return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */