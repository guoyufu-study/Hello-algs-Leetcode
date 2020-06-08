package com.jasper.algs.leetcode.dynamicprogramming.qu0032.solu2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 0032. 最长有效括号
 * 
 * <p> 动态规划
 */
class Solution {
    public int longestValidParentheses(String s) {
    	// 边界
		if(s==null || s.length()<2)
    		return 0;
    	
		int ans = 0;
		
		int length = s.length();
    	int[] dp = new int[length];
    	dp[0] = 0;
    	for (int i = 1; i < length; i++) {
    		if(s.charAt(i)=='(')
    			dp[i] = 0;
    		else {
    			// 有效括号
    			if(i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1)=='(') {
    				// （A）、（）
    				dp[i] = dp[i-1] + 2;
    				// 左扩：B（A）、B（）
        			if(i-dp[i-1]-2>=0) {
        				dp[i] += dp[i-dp[i-1]-2];
        			}
        			ans = Math.max(ans, dp[i]);
    			} 
    			// 无效括号
    			else {
    				dp[i] = 0;
    			}
    				
    		}
		}
    	
    	return ans;
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