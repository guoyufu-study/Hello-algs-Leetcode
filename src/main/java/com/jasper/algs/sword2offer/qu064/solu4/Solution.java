package com.jasper.algs.sword2offer.qu064.solu4;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * 
 * <p> 递归 + 异常终止
 */
class Solution {
	
	int[] test = new int[] { 0 };

	public int sumNums(int n) {
		try {
			return test[n];
		} catch (Exception e) {
			return n + sumNums(n - 1);
		}
	}

	public static void main(String[] args) {
		
		// 50005000
		int n = 10000;
		
		System.out.println(new Solution().sumNums(n));

	}
}