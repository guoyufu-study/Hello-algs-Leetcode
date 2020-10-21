package com.jasper.algs.contest.weekly.c172.qu1326.solu1;

import java.util.Arrays;

/**
 * 1326. 灌溉花园的最少水龙头数目
 * 
 * <p>动态规划
 */
class Solution {
    public int minTaps(int n, int[] ranges) {
    	
    	// 索引：右边界  -> 值：左边界
    	int[] prev = new int[n+1];
    	for (int i = 0; i <= n; i++) prev[i] = i;
    	for (int i = 0; i <= n; i++) {
    		// 约束区间范围 [0,n]
			int l = Math.max(0, i-ranges[i]);
			int r = Math.min(n, i+ranges[i]);
			// 将区间左边界 绑定到 右边界
			prev[r] = Math.min(prev[r], l);
		}
    	
    	// 动态规划
    	int[] dp = new int[n+1];
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[0] = 0;
    	for (int i = 1; i <= n; i++) {
			for (int j = prev[i]; j < i; j++) {// [prev[i], i-1]
				if(dp[j]!=Integer.MAX_VALUE) // 排除无效值
					dp[i] = Math.min(dp[j]+1, dp[i]);
			}
		}
    	
    	return (dp[n]==Integer.MAX_VALUE? -1 : dp[n]);
    }
    
    public static void main(String[] args) {
    	// -1
    	int n = 3;
    	int[] ranges = new int[] {0,0,0,0};
    	
    	// 3
//    	int n = 7;
//    	int[] ranges = new int[] {1,2,1,0,2,1,0,1};
    	
    	// -1
//    	int n = 3;
//    	int[] ranges = new int[] {0,0,0,0};
    	
    	// 1
//    	int n = 5;
//    	int[] ranges = new int[] {3,4,1,1,0,0};
    	
    	
    	System.out.println(new Solution().minTaps(n, ranges));
	}
}