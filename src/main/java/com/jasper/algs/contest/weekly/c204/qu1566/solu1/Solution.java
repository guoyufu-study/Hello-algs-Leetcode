package com.jasper.algs.contest.weekly.c204.qu1566.solu1;

/**
 * 1566. 重复至少 K 次且长度为 M 的模式
 * 
 * <p> 暴力枚举
 */
class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
    	int n = arr.length, limit = n-m*k;
    	if(limit < 0) return false;
    	
    	for (int i = 0; i <= limit; i++) {
			int left = i;
			start : for (int j = 1; j < k; j++) {
				int right = i+j*m;
				for (int p = 0; p < m; p++) {
					if(arr[left+p]!=arr[right+p]) break start;
				}
				if(j==k-1) return true;
			}
		}
    	
    	return false;
    }
}