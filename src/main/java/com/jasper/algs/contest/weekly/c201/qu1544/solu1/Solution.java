package com.jasper.algs.contest.weekly.c201.qu1544.solu1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1503. 整理字符串
 * 
 * <p> 辅助栈
 */
class Solution {
    public String makeGood(String s) {
    	Deque<Character> stack = new LinkedList<Character>();
        for(char c : s.toCharArray()) {
            if(!stack.isEmpty() && c != stack.peek() && Character.toUpperCase(c) == Character.toUpperCase(stack.peek())) {
            	stack.pop();// 消除
            } else {
            	stack.push(c);// 记忆
            }
        }
        
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()) {
        	ans.append(stack.pollLast());
        }
        return ans.toString();
    }
    
    public static void main(String[] args) {
    	// leetcode
		String s = "leEeetcode";
		
		// 空字符串
//		String s = "abBAcC";
		
		// S
//    	String s = "s";
    	
		System.out.println(new Solution().makeGood(s));
	}
}