package com.jasper.algs.leetcode.twopointers.qu0844.solu1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 0844. 比较含退格的字符串
 *
 * <p> 重构字符串
 */
class Solution {
	
    public boolean backspaceCompare(String S, String T) {
    	return rebuild(S).equals(rebuild(T));
    }
    
    private String rebuild(String S) {
    	Deque<Character> stack = new LinkedList<Character>();
    	for (Character c : S.toCharArray()) {
			if(c!='#') 
				stack.push(c);
			else if(!stack.isEmpty()) 
				stack.pop();
		}
    	
    	return String.valueOf(stack);
    }
    
	public static void main(String[] args) {
    	// true
//    	String S = "ab#c";
//    	String T = "ad#c";
    	
    	// true
//    	String S = "ab##";
//    	String T = "c#d#";
    	
    	// true
//    	String S = "a##c";
//    	String T = "#a#c";
    	
    	// false
//    	String S = "a#c";
//    	String T = "b";
    	
    	// true
    	String S = "nzp#o#g";
    	String T = "b#nzp#o#g";
    	
    	
    	System.out.println(new Solution().backspaceCompare(S, T));
	}
}