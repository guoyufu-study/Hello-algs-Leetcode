package com.jasper.algs.leetcode.stack.qu0155.solu1;

import java.util.Stack;

/**
 * 两个栈，数据栈，辅助栈（存每次最小值）
 */
class MinStack {
	
	private Stack<Integer> helper;
	private Stack<Integer> data;

    /** 初始化数据结构 */
    public MinStack() {
    	helper = new Stack<Integer>();
    	data = new Stack<Integer>();
    }
    
    public void push(int x) {
    	if(data.isEmpty()) {
    		data.push(x);
    		helper.push(x);
    		return ;
    	}
    	data.push(x);
    	helper.push(Math.min(x, helper.peek()));
    }
    
    public void pop() {
    	data.pop();
    	helper.pop();
    }
    
    public int top() {
    	return data.peek();
    }
    
    public int getMin() {
    	return helper.peek();
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