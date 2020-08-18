package com.jasper.algs.leetcode.dynamicprogramming.qu0032.solu4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 0032. 最长有效括号
 * 
 * <p> 双计数器
 */
class Solution {
    public int longestValidParentheses(String s) {
    	// 边界
    	if(s==null || s.length()<2) 
    		return 0;
    	
    	// 从左往右扫描
    	int ans = 0, left=0, right=0;
    	for (char c : s.toCharArray()) {
    		// 开括号
			if(c=='(')
				left++;
			
			// 闭括号
			else {
				right++;
				// 有效括号
				if(right==left)
					ans = Math.max(ans, left<<1);
				// 无效括号
				else if(right>left)
					left=right=0;
			}
		}
    	
    	// 从右往左扫描
    	left=right=0;
    	for (int i = s.length()-1; i >= 0; i--) {
    		// 闭括号
			if(s.charAt(i)==')')
				right++;
			
			// 开括号
			else {
				left++;
				// 有效括号
				if(left==right)
					ans = Math.max(ans, left<<1);
				// 无效括号
				else if(left>right)
					left=right=0;
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