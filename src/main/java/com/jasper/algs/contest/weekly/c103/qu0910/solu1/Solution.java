package com.jasper.algs.contest.weekly.c103.qu0910.solu1;

import java.util.Arrays;

/**
 * 0910. 最小差值 II
 * 
 * <p> 线性扫描
 */
class Solution {
    public int smallestRangeII(int[] A, int K) {
    	Arrays.sort(A);
    	int n = A.length, 
    			ans = A[n-1] - A[0], // 全加 K = 全减 K
    			a = A[0] + K, d = A[n-1] - K;// 左侧加，右侧减
    			
    	for (int i = 0; i < n-1; i++) {
			int b = A[i] + K;
			int c = A[i+1] - K;
			int min = Math.min(a, c);
			int max = Math.max(b, d);
			ans = Math.min(max-min, ans);
		}
    	
    	return ans;
    }
}