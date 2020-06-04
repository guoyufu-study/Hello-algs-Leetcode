package com.jasper.algs.leetcode.stack.qu0739.solu1;

import java.util.Stack;
import java.util.stream.IntStream;

/**
 * 0739. 每日温度
 * 
 * <p> 单调栈（左->右）
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {

    	Stack<Integer> stack = new Stack<Integer>();
    	for (int i = 0; i < T.length; i++) {
    		// 找到了更高气温
			while(!stack.isEmpty() && T[stack.peek()] < T[i]){
				int pop = stack.pop();
				T[pop] = i - pop;
			}
			
			stack.push(i);
		}
    	
    	// 没找到更高气温
    	for (int index : stack) {
			T[index] = 0;
		}
    	
    	return T;
    }
    
    public static void main(String[] args) {
    	// 1, 1, 4, 2, 1, 1, 0, 0
    	int[] T = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
		
    	new Solution().dailyTemperatures(T);
    	
		IntStream.of(T).forEach( t -> {
			System.out.print(t + ",");
		});
	}
}