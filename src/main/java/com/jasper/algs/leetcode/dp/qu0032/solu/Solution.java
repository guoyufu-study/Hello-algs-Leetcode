package com.jasper.algs.leetcode.dp.qu0032.solu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 0032. 最长有效括号
 * 
 * <p> 5刷
 */
class Solution {
    public int longestValidParentheses(String s) {
    	
    	return 0;
    }
    
    public static void main(String[] args) {
    	// 2
		String[] ss = new String[] {
				"(()", // 2
				")()())", // 4
		};
		
		List<Integer> ans = Arrays.stream(ss)
			.map(new Solution()::longestValidParentheses)
			.collect(Collectors.toList());
		
		System.out.println(ans);
	}
}