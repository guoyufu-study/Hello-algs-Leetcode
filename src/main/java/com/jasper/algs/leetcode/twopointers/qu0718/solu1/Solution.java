package com.jasper.algs.leetcode.twopointers.qu0718.solu1;

/**
 * 0718. 最长重复子数组
 * 
 * <p> 暴力枚举 （超时）
 */
class Solution {

	public int findLength(int[] A, int[] B) {
		
		int n = A.length, m = B.length, ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int k = 0;
				while(i+k<n && j+k<m && A[i+k]==B[j+k]) {
					k++;
				}
				ans = Math.max(ans, k);
			}
		}
		return ans;
	}
}
