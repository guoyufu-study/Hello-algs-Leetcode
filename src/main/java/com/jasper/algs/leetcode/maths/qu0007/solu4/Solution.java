package com.jasper.algs.leetcode.maths.qu0007.solu4;

/**
 * 设置边界值
 */
public class Solution {

	public int reverse(int x) {
		int ans = 0;
		// 边界值
		int limit = x<0?Integer.MIN_VALUE:-Integer.MAX_VALUE;
		while(x!=0) {
			int digit = x<0?-(x%10):x%10;
			if(ans<(limit+digit)/10) return 0;//边界值处理
			ans = ans*10-digit;
			x/=10;
		}
		
		return limit==Integer.MIN_VALUE?ans:-ans;
	}
	
}
