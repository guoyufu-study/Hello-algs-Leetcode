package com.jasper.algs.leetcode.stack.qu0155;

import java.util.Stack;

class MinStack {
	
	private Stack<Integer> minStack;
	private Stack<Integer> orginStack;

    /** 初始化数据结构 */
    public MinStack() {
    	minStack = new Stack<Integer>();
    	orginStack = new Stack<Integer>();
    }
    
    public void push(int x) {
    	if(orginStack.isEmpty()) {
    		orginStack.push(x);
    		minStack.push(x);
    		return ;
    	}
    	orginStack.push(x);
    	minStack.push(Math.min(x, minStack.peek()));
    }
    
    public void pop() {
    	orginStack.pop();
    	minStack.pop();
    }
    
    public int top() {
    	return orginStack.peek();
    }
    
    public int getMin() {
    	return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */