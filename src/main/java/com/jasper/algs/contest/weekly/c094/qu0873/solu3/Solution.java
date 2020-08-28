package com.jasper.algs.contest.weekly.c094.qu0873.solu3;

import java.util.Arrays;

/**
 * 0873. 最长的斐波那契子序列的长度
 * 
 * <p> 动态规划
 */
class Solution {
    public int lenLongestFibSubseq(int[] A) {
    	int n = A.length;
    	// 动态规划数组表示结尾数字索引为i，j所决定的数列最大长度
		int[][] dp = new int[n][n];
        for (int[] array : dp) Arrays.fill(array, 2);

        int res = 0;
        for (int j = 1; j < n; j++) {
            // 双指针，向前扩展
            int left = 0, right = j - 1;
            while (left < right) {
                // 构成数列
                if (A[left] + A[right] == A[j]) {
                    dp[right][j] = Math.max(dp[right][j], dp[left][right] + 1);
                    res = Math.max(res, dp[right][j]);
                    left++;
                    right--;
                } else if (A[left] + A[right] < A[j]) left++;
                else right--;
            }
        }
        return res;
    }
}