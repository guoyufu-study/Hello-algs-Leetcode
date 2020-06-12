package com.jasper.algs.leetcode.string.qu0006.solu2;

/**
 * 0006. Z字形变换
 * 
 * <p> 按行访问
 */
public class Solution {

	public String convert(String s, int numRows) {
		// 边界
		if(numRows==1) return s;
		
		int n = s.length();
		
		// 按行读
		StringBuilder ans = new StringBuilder();
		int cycleLen = 2*numRows -2;
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j + i < n; j+=cycleLen) {
				ans.append(s.charAt(j+i));
				if(i!=0 && i!=numRows-1 && j+cycleLen-i<n) {
					ans.append(s.charAt(j+cycleLen-i));
				}
			}
		}
		
		return ans.toString();
    }
}
