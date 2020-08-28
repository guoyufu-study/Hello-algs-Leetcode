package com.jasper.algs.leetcode.dp.qu0546.solu1;

/**
 * 0546. 移除盒子
 *
 * <p> 动态规划：记忆化搜索
 */
class Solution {
	
	int[][][] dp;
	int[] boxes;
    public int removeBoxes(int[] boxes) {
    	this.boxes = boxes;
    	int n = boxes.length;
    	dp = new int[n][n][n];
    	
    	return calculatePoints(0, n, 0);
    }

	private int calculatePoints(int l, int r, int k) {
		if(l > r) return 0;
		if(dp[l][r][k]!=0) return dp[l][r][k];
		
		while(l<r && boxes[r] == boxes[r-1]) {// 简单优化
			r--;
			k++;
		}
		dp[l][r][k] = calculatePoints(l, r-1, 0) + (k+1) * (k+1);

		for (int i = l; i < r; i++) {
			if(boxes[i]==boxes[r])
				dp[l][r][k] = Math.max(dp[l][r][k], calculatePoints(l, i, k+1) + calculatePoints(i+1, r-1, 0));
		}
		
		return dp[l][r][k];
	}
}