package com.jasper.algs.interview.qu0301.solu1;

/**
 * 面试题 03.01. 三合一
 * 
 * <p> 简单实现
 */
class TripleInOne {

	private int stackSize;
	private int[] arr;
	private int[] length = new int[3];
	
    public TripleInOne(int stackSize) {
    	this.stackSize = stackSize;
    	arr = new int[3 * stackSize];
    }
    
    public void push(int stackNum, int value) {
    	if(length[stackNum]<stackSize)
    		arr[stackNum*stackSize + length[stackNum]++] = value;
    }
    
    public int pop(int stackNum) {
    	if(length[stackNum]>0) 
    		return arr[stackNum*stackSize + (--length[stackNum])];
    	
    	return -1;
    }
    
    public int peek(int stackNum) {
    	if(length[stackNum]>0) 
    		return arr[stackNum*stackSize + (length[stackNum]-1)];
    	
    	return -1;
    }
    
    public boolean isEmpty(int stackNum) {

    	return length[stackNum]>0 ? false : true;
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */