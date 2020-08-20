package com.jasper.algs.leetcode.dp.qu0032.solu2;

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
    	
    	int n = s.length(), ans = 0;
    	int[] dp = new int[n];
    	for (int i = 1; i < n; i++) {
			if(s.charAt(i)==')') {
                int j = i - dp[i-1] - 1;
                if(j>=0 && s.charAt(j)=='(') {
                    dp[i] = dp[i-1] + 2;
                    if(j-1>=0)
                        dp[i] += dp[j-1];
                    ans = Math.max(ans, dp[i]);
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