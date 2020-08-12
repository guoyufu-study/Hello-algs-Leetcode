package com.jasper.algs.interview.qu0305.solu1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题 03.05. 栈排序
 * 
 * <p> 简单实现
 */
class SortedStack {

    Deque<Integer> stack;
    Deque<Integer> helper;

    public SortedStack() {
        stack = new LinkedList<Integer>();
        helper = new LinkedList<Integer>();
    }
    
    public void push(int val) {
        while(!stack.isEmpty() && stack.peek() < val)
            helper.push(stack.pop());

        stack.push(val);
        while(!helper.isEmpty()) {
            stack.push(helper.pop());
        }
    }
    
    public void pop() {
        if(!stack.isEmpty())
            stack.pop();
    }
    
    public int peek() {
        return stack.isEmpty() ? -1 : stack.peek();
    }
    
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */