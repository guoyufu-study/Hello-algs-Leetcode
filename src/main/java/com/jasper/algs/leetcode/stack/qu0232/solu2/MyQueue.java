package com.jasper.algs.leetcode.stack.qu0232.solu2;

import java.util.Stack;

/**
 * 两个栈 入队 - O(1)，出队 - 摊还复杂度 O(1)
 */
class MyQueue {
	
	private Stack<Integer> outStack;
	private Stack<Integer> inStack;
	
    /** 初始化数据结构 */
    public MyQueue() {
    	inStack = new Stack<Integer>();
    	outStack = new Stack<Integer>();
    }
    
    /** 入队 */
    public void push(int x) {
    	inStack.push(x);
    }
    
    /** 出队 */
    public int pop() {
    	if(outStack.isEmpty())
    		while(!inStack.isEmpty())
    			outStack.push(inStack.pop());
    	return outStack.pop();
    }
    
    /** 队首元素  */
    public int peek() {
    	if(outStack.isEmpty())
    		while(!inStack.isEmpty())
    			outStack.push(inStack.pop());
    	return outStack.peek();
    }
    
    /** 判空   */
    public boolean empty() {
    	return outStack.isEmpty() && inStack.isEmpty();
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */