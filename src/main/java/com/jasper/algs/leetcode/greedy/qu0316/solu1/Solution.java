package com.jasper.algs.leetcode.greedy.qu0316.solu1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * 0316. 去除重复字母
 * 
 * <p> 贪心算法
 */
class Solution {
    public String removeDuplicateLetters(String s) {
    	
    	// 边界
    	if(s==null || s.length()==1)
    		return s;
    	
    	int N = s.length();
    	
    	// 记录字符最后一次出现的位置
    	Map<Character, Integer> lastOccurrence = new HashMap<>();
    	for (int i = 0; i < N; i++) {
    		lastOccurrence.put(s.charAt(i), i);
		}
    	
    	// 记录字符是否已入栈
    	Set<Character> seen = new HashSet<>();
    	Stack<Character> helper = new Stack<>();
    	for (int i = 0; i < N; i++) {
			char c = s.charAt(i);
			
			// 已入栈，跳过
			if(seen.contains(c)) continue;
			
			// 出栈非法字符
			while(!helper.isEmpty() && helper.peek()>c &&
					lastOccurrence.get(helper.peek())>i)
				seen.remove(helper.pop());
			// 入栈
			helper.add(c);
			// 记录已入栈
			seen.add(c);
		}
    	
    	// 构造答案
    	StringBuilder sb = new StringBuilder(helper.size());
        for (Character c : helper) sb.append(c.charValue());
    	return sb.toString();
    }
}