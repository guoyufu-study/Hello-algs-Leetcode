package com.jasper.algs.leetcode.maths.qu0233.solu2;

/**
 * 0233. 数字 1 的个数
 * 
 * <p> 数学性质
 */
public class Solution {

	public int countDigitOne(int n) {
		
		int ans = 0;
	    for (long baseCount = 1; baseCount <= n; baseCount *= 10) {
	        long divider = baseCount * 10; // 注意溢出问题
	        ans += (n / divider) * baseCount + 
	        		Math.min(Math.max(n % divider - baseCount + 1, 0), baseCount);
	    }

		return ans;
    }
	
	public static void main(String[] args) {
		// 0
//		int n = 0;
		
		// 1
//		int n = 2;
		
		// 13
//		int n = 22;
		
		// 20
//		int n = 99;
		
		// 20
//		int n = 100;
		
		// 153
//		int n = 222;
		
		// 300
//		int n = 999;
		
		// 1753
//		int n = 2222;
		
		// 注意溢出问题
		// 1737167499
		int n = 1410065408;
		
		System.out.println(new Solution().countDigitOne(n));
	}
}
