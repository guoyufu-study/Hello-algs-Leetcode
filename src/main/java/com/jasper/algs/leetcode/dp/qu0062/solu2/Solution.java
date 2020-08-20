package com.jasper.algs.leetcode.dp.qu0062.solu2;

import java.util.Arrays;

/**
 * 0062. 不同路径
 *
 * <p>动态规划：状态压缩
 */
class Solution {
    public int uniquePaths(int m, int n) {
    	
    	// 一维数组
    	int[] helper = new int[n];
    	Arrays.fill(helper, 1);
    	
    	for (int i = 1; i < m; i++) 
			for (int j = 1; j < n; j++) 
				helper[j] = helper[j] + helper[j-1];
    	
    	return helper[n-1];
    }
}