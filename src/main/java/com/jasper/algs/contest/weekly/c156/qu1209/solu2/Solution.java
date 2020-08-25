package com.jasper.algs.contest.weekly.c156.qu1209.solu2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1209. 删除字符串中的所有相邻重复项 II
 * 
 * <p> 辅助栈
 */
class Solution {
    public String removeDuplicates(String s, int k) {
    	Deque<Pair> stack = new LinkedList<Pair>();
    	char[] sc = s.toCharArray();
    	int n = s.length(), right = 0;
    	while(right < n) {
    		if(stack.isEmpty() || sc[right]!=stack.peek().c) {
    			stack.push(new Pair(sc[right], 1));
    		} else {
    			stack.peek().len += 1;
    			if(stack.peek().len == k) 
    				stack.pop();
    		}
    		right++;
    	}
    	
    	StringBuilder ans = new StringBuilder(s);
    	while(!stack.isEmpty()) {
    		Pair tmp = stack.pollLast();
    		for (int i = 0; i < tmp.len; i++) {
				ans.append(tmp.c);
			}
    	}
    	
    	return ans.toString();
    }
    
    class Pair {
    	char c;
    	int len;
		public Pair(char c, int len) {
			super();
			this.c = c;
			this.len = len;
		}
    }
    
}