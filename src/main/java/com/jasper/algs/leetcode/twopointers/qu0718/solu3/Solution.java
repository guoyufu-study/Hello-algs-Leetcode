package com.jasper.algs.leetcode.twopointers.qu0718.solu3;

/**
 * 0718. 最长重复子数组
 * 
 * <p> 滑动窗口
 */
class Solution {

	public int findLength(int[] A, int[] B) {
		int n = A.length, m = B.length, ans = 0;
        
		for (int i = 0; i < n; i++) {
			int len = Math.min(m, n-i);
			if(len <= ans) break;
			ans = Math.max(ans, maxLen(A, B, i, 0, len));
		}

		for (int j = 0; j < m; j++) {
			int len = Math.min(n, m-j);
			if(len <= ans) break;
			ans = Math.max(ans, maxLen(A, B, 0, j, len));
		}
		
        return ans;
	}

	private int maxLen(int[] A, int[] B, int addA, int addB, int len) {
		int k=0, ans=0;
		for (int i = 0; i < len; i++) {
			k = A[addA + i]==B[addB + i] ? k+1 : 0;
			ans = Math.max(ans, k);
		}
		return ans;
	}
}
