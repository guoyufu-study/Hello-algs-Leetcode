package com.jasper.algs.contest.weekly.c169.qu1304.solu1;

/**
 * 1304. 和为零的N个唯一整数
 * 
 * <p> n-1 个正数，一个负数
 */
class Solution {
    public int[] sumZero(int n) {
    	int[] ans = new int[n];
		int sum = 0;
		for(int i = 1; i < n; i++) {
			ans[i] = i;
			sum -=i;
		}
		ans[0] = sum;
		return ans;
    }
}
